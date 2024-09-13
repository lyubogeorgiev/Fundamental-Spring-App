package com.georgievl.fundamentalspringapp.services;

import com.georgievl.fundamentalspringapp.domain.Course;
import com.georgievl.fundamentalspringapp.repositories.CourseRepository;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Iterable<Course> findAll() {
        return courseRepository.findAll();
    }
}
