package hr.tvz.spring.crnjak1.repository;

import hr.tvz.spring.crnjak1.domain.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {

    List<Student> findAll();
    Optional<Student> findStudentByJMBAG(String JMBAG);

    Optional<Student> save(Student student);

    void deleteByJMBAG(String JMBAG);

}
