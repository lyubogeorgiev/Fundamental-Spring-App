package com.georgievl.fundamentalspringapp.repositories;

import com.georgievl.fundamentalspringapp.domain.Instructor;
import org.springframework.data.repository.CrudRepository;

public interface InstructorRepository extends CrudRepository<Instructor, Long>{
}
