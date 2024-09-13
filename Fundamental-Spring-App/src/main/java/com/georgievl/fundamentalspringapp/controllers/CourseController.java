package com.georgievl.fundamentalspringapp.controllers;

import com.georgievl.fundamentalspringapp.services.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @RequestMapping("/courses")
    public String getCourses(Model model) {
        model.addAttribute("course", courseService.findAll());

        return "courses";
    }
}
