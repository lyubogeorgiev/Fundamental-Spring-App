package com.georgievl.fundamentalspringapp.services;

import com.georgievl.fundamentalspringapp.domain.Student;

public interface StudentService {
    Iterable<Student> findAll();
}
