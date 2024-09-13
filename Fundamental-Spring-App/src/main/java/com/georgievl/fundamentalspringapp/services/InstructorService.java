package com.georgievl.fundamentalspringapp.services;

import com.georgievl.fundamentalspringapp.domain.Instructor;

public interface InstructorService {
    Iterable<Instructor> findAll();
}
