package ru.hogvarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogvarts.school.model.Student;
import ru.hogvarts.school.service.StudentService;

import java.util.Collection;
import java.util.Collections;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @GetMapping("{id}")
    public ResponseEntity <Student> getStudent(@PathVariable Long id) {
        Student student = studentService.getStudent(id);
        if (student == null) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @PutMapping("{id}")
    public ResponseEntity <Student> editStudent(@PathVariable Long id, @RequestBody Student student) {
        Student editorialStudent = studentService.editStudent(id, student);
        if (editorialStudent == null) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(editorialStudent);
    }

    @DeleteMapping("{id}")
    public ResponseEntity <Student> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity <Collection<Student>> getStudentToAge(@RequestParam (required = false) int age) {
        if (age > 0) {
            return ResponseEntity.ok(studentService.getStudentToAge(age));
        }
        return ResponseEntity.ok(Collections.emptyList());
    }

}
