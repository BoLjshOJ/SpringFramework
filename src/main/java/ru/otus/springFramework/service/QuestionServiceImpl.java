package ru.otus.springFramework.service;

import ru.otus.springFramework.dao.QuestionDao;
import ru.otus.springFramework.domain.Question;
import ru.otus.springFramework.domain.Student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class QuestionServiceImpl implements QuestionService {
    private final QuestionDao questionDao;

    public QuestionServiceImpl(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    public void askQuestion(Student student) {
        System.out.printf("Please %s, answer the questions", student.getName());
        List<Integer> answersOfStudent = new ArrayList<>();
        List<Integer> rightAnswers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            for (Question question : questionDao.getQuestions()){
                System.out.println(question);
                rightAnswers.add(question.getCorrectAnswer());
                String ans = reader.readLine();
                if (ans.isEmpty()){
                    answersOfStudent.add(0);
                } else {
                    answersOfStudent.add(Integer.parseInt(ans));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        student.setCountOfRightAnswers(checkAnswers(answersOfStudent, rightAnswers));
    }

    public int checkAnswers(List<Integer> studentAnswers, List<Integer> correctAnswer) {
        int result = 0;
        for (int i = 0; i < studentAnswers.size(); i++){
            if (studentAnswers.get(i) == correctAnswer.get(i)){
                result++;
            }
        }
        return result;
    }
}