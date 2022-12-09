package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.exceptions.FacultyNotFoundExceptions;
import ru.hogwarts.school.model.Faculty;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Service
public class FacultyService {
    private long counter = 0L;
    private final Map<Long, Faculty> faculties = new HashMap<>();

    public Faculty addFaculty(Faculty faculty) {
        long newId = this.counter++;
        faculty.setId(newId);
        faculties.put(newId, faculty);
        return faculty;
    }

    public Faculty editFaculty(Long id, Faculty faculty) {
        if (this.faculties.containsKey(id)) {
            Faculty oldFaculty = this.faculties.get(id);
            oldFaculty.setColor(faculty.getColor());
            oldFaculty.setName(faculty.getName());
            return oldFaculty;
        } else {
            throw new FacultyNotFoundExceptions();
        }
    }

    public Collection<Faculty> getAll() {
        return this.faculties.values();
    }

    public Faculty getFaculty(Long id) {
        if (this.faculties.containsKey(id)) {
            return this.faculties.get(id);
        }else {
            throw new FacultyNotFoundExceptions();
        }
    }
    public void removeFaculty(Long id) {
        if (this.faculties.containsKey(id)){
            this.faculties.remove(id);
        }
        else {
            throw new FacultyNotFoundExceptions();
        }
    }
}
