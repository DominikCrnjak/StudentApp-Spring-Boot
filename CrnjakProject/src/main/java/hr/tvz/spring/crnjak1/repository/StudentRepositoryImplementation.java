package hr.tvz.spring.crnjak1.repository;

import hr.tvz.spring.crnjak1.domain.Student;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class StudentRepositoryImplementation implements StudentRepository {

    private List<Student> studentList;

    private static final String SELECT_ALL = "SELECT id, jmbag, first_name, last_name, ects_points, date_of_birth FROM student";

    private final JdbcTemplate jdbc;
    private final SimpleJdbcInsert inserter;

    public StudentRepositoryImplementation(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
        this.inserter = new SimpleJdbcInsert(jdbc)
                .withTableName("student")
                .usingGeneratedKeyColumns("id");
    }
    @Override
    public List<Student> findAll() {
        return List.copyOf(jdbc.query(SELECT_ALL, this::mapRowToStudent));
    }

    @Override
    public Optional<Student> findStudentByJMBAG(String JMBAG) {
        try{
            return Optional.ofNullable(
                    jdbc.queryForObject(SELECT_ALL + " WHERE jmbag = ?", this::mapRowToStudent, JMBAG)
            );
        } catch (EmptyResultDataAccessException e){
            return Optional.empty();
        }
    }
    @Override
    public Optional<Student> save(final Student student) {
        try {
            student.setId(saveStudentDetails(student));
            return Optional.of(student);
        } catch (DuplicateKeyException e){
            return Optional.of(student);
        }
    }

    private long saveStudentDetails(Student student) {
        Map<String, Object> values = new HashMap<>();

        values.put("first_name", student.getFirstName());
        values.put("last_name", student.getLastName());
        values.put("jmbag", student.getJmbag());
        values.put("date_of_birth", student.getDateOfBirth());
        values.put("ects_points", student.getNumberOfECTS());

        return inserter.executeAndReturnKey(values).longValue();
    }

    private Student mapRowToStudent(ResultSet rs, int rowNum) throws SQLException {
        return new Student(
                rs.getLong("id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getDate("date_of_birth").toLocalDate(),
                rs.getString("jmbag"),
                rs.getInt("ects_points")
        );
    }

    @Override
    public void deleteByJMBAG(final String JMBAG) {
        jdbc.update("DELETE FROM student WHERE jmbag = ?", JMBAG);
    }


}
