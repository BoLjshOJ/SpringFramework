package ru.otus.springFramework.domain;

import org.springframework.beans.factory.annotation.Autowired;
import ru.otus.springFramework.service.MessageService;

import java.util.Iterator;
import java.util.List;

public class Question {
    private MessageService messageService;
    private String textOfQuestion;
    private List<String> answers;
    private int correctAnswer;

    @Autowired
    public Question(String textOfQuestion, List<String> answers, int correctAnswer, MessageService messageService) {
        this.textOfQuestion = textOfQuestion;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
        this.messageService = messageService;
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
        sb.append(this.textOfQuestion + "\n" + messageService.getMessage("varOfAnswers"));
        Iterator iterator = this.answers.iterator();

        while (iterator.hasNext()){
            String answer = (String) iterator.next();
            sb.append("\n" + answer);
        }
        return sb.toString();
    }
}