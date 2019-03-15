package ru.otus.springFramework.domain;

import ru.otus.springFramework.service.MessageService;

import java.security.MessageDigest;

public class Student {
    private final String name;
    private final String surname;
    private int countOfRightAnswers;
    private MessageService messageService;

    public Student(String name, String surname, MessageService messageService) {
        this.name = name;
        this.surname = surname;
        this.messageService = messageService;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getCountOfRightAnswers() {
        return countOfRightAnswers;
    }

    public void setCountOfRightAnswers(int countOfRightAnswers) {
        this.countOfRightAnswers = countOfRightAnswers;
    }

    @Override
    public String toString() {
        return messageService.getMessage("student") +
                " " +
                name +
                " " +
                surname +
                ". " +
                messageService.getMessage("answered") +
                " " +
                countOfRightAnswers;
    }
}