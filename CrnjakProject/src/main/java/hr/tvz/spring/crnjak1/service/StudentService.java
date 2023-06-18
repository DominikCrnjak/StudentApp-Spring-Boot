package hr.tvz.spring.crnjak1.service;

import hr.tvz.spring.crnjak1.command.StudentCommand;
import hr.tvz.spring.crnjak1.domain.Student;
import hr.tvz.spring.crnjak1.domain.StudentDTO;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<StudentDTO> findAll();
    Optional<StudentDTO> findStudentByJMBAG(String JMBAG);

    Optional<StudentDTO> save(StudentCommand studentCommand);

    void deleteByJMBAG(String JMBAG);


}

