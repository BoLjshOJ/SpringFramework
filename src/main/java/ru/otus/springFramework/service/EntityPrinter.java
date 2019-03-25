package ru.otus.springFramework.service;

import ru.otus.springFramework.domain.Question;
import ru.otus.springFramework.domain.Student;

public interface EntityPrinter {
    String printStudent(Student student);
    String printQuestion(Question question);
}
