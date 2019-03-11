package service;

import dao.StudentDao;
import domain.Student;

public class StudentServiceImpl implements StudentService {
    private final StudentDao dao;

    public StudentServiceImpl(StudentDao dao) {
        this.dao = dao;
    }

    public Student createStudent() {
        return dao.createStudent();
    }
}