package domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Student {
    private final String name;
    private final String surname;
    private int countOfRightAnswers;

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
        countOfRightAnswers = 0;
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
        return "Student " +
                name +
                " " +
                surname +
                ". " +
                "Количество правильных ответов: " +
                countOfRightAnswers;
    }

    public List<String> askQuestions(List<String> questions) {
        System.out.println("Просьба ответить на вопросы ниже: ");
        List<String> answersOfStudent = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            for (String question : questions){
                System.out.println(question);
                answersOfStudent.add(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return answersOfStudent;
    }

    public void checkAnswers(List<String> answersOfStudent, List<String> rightAnswers){
        int points = 0;
        for (int i = 0; i < answersOfStudent.size(); i++){
            if (answersOfStudent.get(i).toLowerCase().equals(rightAnswers.get(i).toLowerCase())){
                points++;
            }
        }
        setCountOfRightAnswers(points);
    }
}