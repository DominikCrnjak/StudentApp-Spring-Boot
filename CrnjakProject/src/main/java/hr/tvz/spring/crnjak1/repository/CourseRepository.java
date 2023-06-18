package hr.tvz.spring.crnjak1.repository;

import hr.tvz.spring.crnjak1.domain.Course;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {


    List<Course> findAll();
    List<Course> findAllByStudents_Jmbag(String jmbag);

}
