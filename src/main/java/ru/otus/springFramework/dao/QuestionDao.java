package ru.otus.springFramework.dao;

import ru.otus.springFramework.domain.Question;

import java.util.List;

public interface QuestionDao {
    void initQuestionsFromCSV();
    List<Question> getQuestions();
}