package ru.otus.springFramework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.springFramework.dao.StudentDao;
import ru.otus.springFramework.domain.Student;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentDao dao;

    @Autowired
    public StudentServiceImpl(StudentDao dao) {
        this.dao = dao;
    }

    public Student createStudent() {
        return dao.createStudent();
    }
}