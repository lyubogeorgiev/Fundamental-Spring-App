package com.georgievl.fundamentalspringapp.services;

import com.georgievl.fundamentalspringapp.domain.Instructor;
import com.georgievl.fundamentalspringapp.repositories.InstructorRepository;
import org.springframework.stereotype.Service;

@Service
public class InstructorServiceImpl implements InstructorService{

    private final InstructorRepository instructorRepository;

    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Override
    public Iterable<Instructor> findAll() {
        return instructorRepository.findAll();
    }
}
