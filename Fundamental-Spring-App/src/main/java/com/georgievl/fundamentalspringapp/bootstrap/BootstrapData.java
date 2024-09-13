package com.georgievl.fundamentalspringapp.bootstrap;

import com.georgievl.fundamentalspringapp.domain.Course;
import com.georgievl.fundamentalspringapp.domain.Instructor;
import com.georgievl.fundamentalspringapp.domain.Student;
import com.georgievl.fundamentalspringapp.repositories.CourseRepository;
import com.georgievl.fundamentalspringapp.repositories.InstructorRepository;
import com.georgievl.fundamentalspringapp.repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final InstructorRepository instructorRepository;

    public BootstrapData(CourseRepository courseRepository, StudentRepository studentRepository, InstructorRepository instructorRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
        this.instructorRepository = instructorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Course course1 = new Course("Spring Boot", "SPR1010");
        Course course2 = new Course("Spring Security", "SSC1110");

        Instructor instructor1 = new Instructor("John Doe", "I213456");

        Student student1 = new Student("Mich Taylor", "S002312");
        Student student2 = new Student("Jane Doe", "S004567");

        Course savedCourse1 = courseRepository.save(course1);
        Course savedCourse2 = courseRepository.save(course2);

        Instructor savedInstructor1 = instructorRepository.save(instructor1);

        Student savedStudent1 = studentRepository.save(student1);
        Student savedStudent2 = studentRepository.save(student2);

        savedCourse1.setInstructor(instructor1);
        savedCourse1.addStudent(student1);
        savedCourse1.addStudent(student2);

        System.out.println("Students in course 1: ");
        savedCourse1.getStudents().forEach(System.out::println);

        savedCourse1 = courseRepository.save(savedCourse1);

        savedStudent1.addCourse(savedCourse1);
        savedStudent2.addCourse(savedCourse2);

        savedStudent1 = studentRepository.save(savedStudent1);
        savedStudent2 = studentRepository.save(savedStudent2);


        System.out.println(courseRepository.count());
    }
}
