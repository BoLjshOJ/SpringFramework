package ru.otus.springFramework;

import org.springframework.context.annotation.*;
import ru.otus.springFramework.domain.Student;
import ru.otus.springFramework.service.QuestionService;
import ru.otus.springFramework.service.QuizService;
import ru.otus.springFramework.service.StudentService;

@ComponentScan
public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        QuizService quizService = context.getBean(QuizService.class);
        quizService.startTest();
    }
}