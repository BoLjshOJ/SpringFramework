package ru.otus.springFramework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.springFramework.dao.QuestionDao;
import ru.otus.springFramework.domain.Question;
import ru.otus.springFramework.domain.Student;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    private final QuestionDao questionDao;
    private final MessageService messageService;
    private final IOService ioService;

    @Autowired
    public QuestionServiceImpl(
            QuestionDao questionDao,
            MessageService messageService,
            IOService ioService
    ) {
        this.questionDao = questionDao;
        this.messageService = messageService;
        this.ioService = ioService;
    }

    public void askQuestion(Student student) {
        System.out.printf(messageService.getMessage("welcomeText") + "\n", student.getName());
        List<Integer> answersOfStudent = new ArrayList<>();
        List<Integer> rightAnswers = new ArrayList<>();

        for (Question question : questionDao.getQuestions()){
            System.out.println(question);
            rightAnswers.add(question.getCorrectAnswer());
            String ans = ioService.getStringFromSonsole();
            if (ans.isEmpty() || ans.matches(".*[^0-9].*")){
                answersOfStudent.add(0);
            } else {
                answersOfStudent.add(Integer.parseInt(ans));
            }
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