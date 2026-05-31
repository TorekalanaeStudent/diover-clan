package com.obedoza.demo.service;

import com.obedoza.demo.model.Student;
import com.obedoza.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student createStudent(String fullName, String course) {
        Student student = new Student();
        student.setFullName(fullName);
        student.setCourse(course);
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, String fullName, String course) {
        return null;
    }
}
