package com.example.demo.controller;

import com.example.demo.model.Course;
import com.example.demo.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<?> addCourse(@RequestBody Course course) {

        if (course.getTitle() == null || course.getTitle().isEmpty()) {
            return ResponseEntity.badRequest().body("Invalid course data");
        }

        Course saved = service.addCourse(course);
        return ResponseEntity.status(201).body(saved); // CREATED
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        return ResponseEntity.ok(service.getAllCourses());
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getCourse(@PathVariable int id) {

        Optional<Course> course = service.getCourseById(id);

        if (course.isPresent()) {
            return ResponseEntity.ok(course.get());
        } else {
            return ResponseEntity.status(404).body("Course not found");
        }
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable int id,
                                          @RequestBody Course course) {

        Optional<Course> updated = service.updateCourse(id, course);

        if (updated.isPresent()) {
            return ResponseEntity.ok(updated.get());
        } else {
            return ResponseEntity.status(404).body("Course not found");
        }
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable int id) {

        boolean deleted = service.deleteCourse(id);

        if (deleted) {
            return ResponseEntity.ok("Course deleted successfully");
        } else {
            return ResponseEntity.status(404).body("Course not found");
        }
    }

    // SEARCH
    @GetMapping("/search/{title}")
    public ResponseEntity<List<Course>> search(@PathVariable String title) {
        return ResponseEntity.ok(service.searchByTitle(title));
    }
}