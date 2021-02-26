package ru.geekbrains.spring.mvc.services;

import ru.geekbrains.spring.mvc.model.Student;
import ru.geekbrains.spring.mvc.repositories.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentsService {
    private StudentsRepository studentsRepository;

    @Autowired
    public void setStudentsRepository(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    public List<Student> getAllStudents() {
        return studentsRepository.findAll();
    }

    public Student saveOrUpdateStudent(Student student) {
        return studentsRepository.saveOrUpdateStudent(student);
    }

    public Student findById(Long id) {
        return studentsRepository.findById(id);
    }
}
