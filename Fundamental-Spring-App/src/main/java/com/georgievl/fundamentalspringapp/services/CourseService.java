package com.georgievl.fundamentalspringapp.services;

import com.georgievl.fundamentalspringapp.domain.Course;

public interface CourseService {
    Iterable<Course> findAll();
}
