package com.georgievl.fundamentalspringapp.repositories;

import com.georgievl.fundamentalspringapp.domain.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
