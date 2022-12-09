package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public Collection<Student> getAll(){
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable("id") long id){
        return studentService.getStudent(id);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @PutMapping("/{id}")
    public Student editStudent(@PathVariable("id") long id, @RequestBody Student student){
        return studentService.editStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable("id") long id){
        this.studentService.removeStudents(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/age/{age}")
    public Collection<Student> getStudentsByAge(@PathVariable("age") int age) {
        return this.studentService.getByAge(age);
    }
}