package hr.tvz.spring.crnjak1.service;

import hr.tvz.spring.crnjak1.command.StudentCommand;
import hr.tvz.spring.crnjak1.domain.Student;
import hr.tvz.spring.crnjak1.domain.StudentDTO;
import hr.tvz.spring.crnjak1.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class StudentServiceImplementation implements StudentService{

    private static final int TUITION_YEARS=26;

    private StudentRepository studentRepository;

    @Override
    public List<StudentDTO> findAll() {
        return studentRepository.findAll().stream().map(this::mapStudentToDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<StudentDTO> findStudentByJMBAG(String JMBAG) {
        return studentRepository.findStudentByJMBAG(JMBAG).map(this::mapStudentToDTO);
    }

    @Override
    public Optional<StudentDTO> save(StudentCommand studentCommand) {
        return studentRepository.save(mapCommandToStudent(studentCommand)).map(this::mapStudentToDTO);
    }

    @Override
    public void deleteByJMBAG(String JMBAG) {
        studentRepository.deleteByJMBAG(JMBAG);
    }

    private boolean shouldTuitionBePayed(LocalDate dateOfBirth){
        return dateOfBirth.plusYears(TUITION_YEARS).isBefore(LocalDate.now());
    }

    private StudentDTO mapStudentToDTO(final Student student){
        return new StudentDTO(student.getJmbag(), student.getNumberOfECTS(), shouldTuitionBePayed(student.getDateOfBirth()));
    }

    private Student mapCommandToStudent(final StudentCommand studentCommand) {
        return new Student(studentCommand.getFirstName(), studentCommand.getLastName(),studentCommand.getDateOfBirth(), studentCommand.getJmbag(), studentCommand.getNumberOfECTS());

    }

}
