package hr.tvz.spring.crnjak1.controller;


import hr.tvz.spring.crnjak1.domain.CourseDTO;
import hr.tvz.spring.crnjak1.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("course")
@CrossOrigin(origins = "http://localhost:4200")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<CourseDTO> getAllCourses(){
        return courseService.findAll();
    }

    @GetMapping(params = "jmbag")
    public List<CourseDTO> getAllCoursesByStudentJmbag(@RequestParam String jmbag){
        return courseService.findAllByStudentJmbag(jmbag);
    }

}