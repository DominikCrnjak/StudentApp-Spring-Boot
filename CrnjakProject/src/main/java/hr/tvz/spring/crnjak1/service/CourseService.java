package hr.tvz.spring.crnjak1.service;

import hr.tvz.spring.crnjak1.domain.CourseDTO;

import java.util.List;

public interface CourseService {
    List<CourseDTO> findAll();

    List<CourseDTO> findAllByStudentJmbag(String jmbag);
}
