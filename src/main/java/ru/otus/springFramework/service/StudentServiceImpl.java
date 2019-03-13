package ru.otus.springFramework.service;

import ru.otus.springFramework.dao.StudentDao;
import ru.otus.springFramework.domain.Student;

public class StudentServiceImpl implements StudentService {
    private final StudentDao dao;

    public StudentServiceImpl(StudentDao dao) {
        this.dao = dao;
    }

    public Student createStudent() {
        return dao.createStudent();
    }
}