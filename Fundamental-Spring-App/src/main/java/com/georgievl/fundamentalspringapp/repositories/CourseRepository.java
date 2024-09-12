package com.georgievl.fundamentalspringapp.repositories;

import com.georgievl.fundamentalspringapp.domain.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {
}
