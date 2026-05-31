package com.obedoza.demo.controller;


import com.obedoza.demo.model.Student;
import com.obedoza.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public ResponseEntity<List<Student>> getStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestParam String fullName, @RequestParam String course) {
        return ResponseEntity.ok(studentService.createStudent(fullName, course));
    }

    @PutMapping("/update")
    public ResponseEntity<Student> updateStudent(
            @RequestParam Long id,
            @RequestParam String fullName,
            @RequestParam String course) {
        return ResponseEntity.ok(studentService.updateStudent(id, fullName, course));
    }

    @DeleteMapping("/")
    public ResponseEntity<Void> deleteStudent(@RequestParam Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.accepted().build();
    }

}
