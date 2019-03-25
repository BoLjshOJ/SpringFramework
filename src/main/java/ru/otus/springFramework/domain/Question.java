package ru.otus.springFramework.domain;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Question {
    private String textOfQuestion;
    private List<String> answers;
    private int correctAnswer;

    @Autowired
    public Question(String textOfQuestion, List<String> answers, int correctAnswer) {
        this.textOfQuestion = textOfQuestion;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
    }

    public String getTextOfQuestion() {
        return textOfQuestion;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}