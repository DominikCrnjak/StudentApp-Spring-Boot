package hr.tvz.spring.crnjak1.service;

import hr.tvz.spring.crnjak1.domain.Course;
import hr.tvz.spring.crnjak1.domain.CourseDTO;
import hr.tvz.spring.crnjak1.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImplementation implements CourseService {
    private final CourseRepository courseRepository;

    public CourseServiceImplementation(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<CourseDTO> findAll() {
        return courseRepository.findAll().stream().map(this::mapCourseToDTO).collect(Collectors.toList());
    }

    @Override
    public List<CourseDTO> findAllByStudentJmbag(String jmbag) {
        return courseRepository.findAllByStudents_Jmbag(jmbag).stream().map(this::mapCourseToDTO).collect(Collectors.toList());
    }

    private CourseDTO mapCourseToDTO(Course course){
        return new CourseDTO(course.getName(), course.getNumberOfECTS());
    }
}
