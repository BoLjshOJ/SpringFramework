package ru.otus.springFramework.domain;

public class Student {
    private final String name;
    private final String surname;
    private int countOfRightAnswers;

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
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
}