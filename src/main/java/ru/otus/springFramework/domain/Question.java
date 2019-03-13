package ru.otus.springFramework.domain;

import java.util.Iterator;
import java.util.List;

public class Question {
    private String textOfQuestion;
    private List<String> answers;
    private int correctAnswer;

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Question: " + this.textOfQuestion + "\nPossible answers:");
        Iterator iterator = this.answers.iterator();

        while (iterator.hasNext()){
            String answer = (String) iterator.next();
            sb.append("\n" + answer);
        }
        return sb.toString();
    }
}