package ru.otus.springFramework.service;

import ru.otus.springFramework.domain.Student;

import java.util.List;

public interface QuestionService {
    void askQuestion(Student student);
    int checkAnswers(List<Integer> answers, List<Integer> correctAnswer);
}