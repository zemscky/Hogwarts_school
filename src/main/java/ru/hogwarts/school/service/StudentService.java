package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.exceptions.StudentsNotFoundExceptions;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Service
public class StudentService {
    private long counter = 0L;
    private final Map<Long, Student> students = new HashMap<>();

    public Student addStudent(Student student) {
        long newId = this.counter++;
        student.setId(newId);
        students.put(newId, student);
        return student;
    }

    public Student editStudent(Long id, Student student) {
        if (this.students.containsKey(id)) {
            Student oldStudents = this.students.get(id);
            oldStudents.setAge(student.getAge());
            oldStudents.setName(student.getName());
            return oldStudents;
        } else {
            throw new StudentsNotFoundExceptions();
        }
    }

    public Collection<Student> getAll() {
        return this.students.values();
    }

    public Student getStudent(Long id) {
        if (this.students.containsKey(id)) {
            return this.students.get(id);
        }else {
            throw new StudentsNotFoundExceptions();
        }
    }
    public void removeStudents(Long id) {
        if (this.students.containsKey(id)){
            this.students.remove(id);
        }
        else {
            throw new StudentsNotFoundExceptions();
        }
    }
}

