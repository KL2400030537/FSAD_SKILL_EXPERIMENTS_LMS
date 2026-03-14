package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.exception.InvalidInputException;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {

    private static Map<Integer, Student> students = new HashMap<>();

    static {
        students.put(1, new Student(1,"Rahul","B.Tech"));
        students.put(2, new Student(2,"Priya","BCA"));
        students.put(3, new Student(3,"Arjun","MCA"));
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id) {

        if(id <= 0){
            throw new InvalidInputException("Student ID must be positive.");
        }

        Student student = students.get(id);

        if(student == null){
            throw new StudentNotFoundException("Student with ID "+id+" not found.");
        }

        return student;
    }
}