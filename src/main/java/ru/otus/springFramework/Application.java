package ru.otus.springFramework;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.springFramework.domain.Student;
import ru.otus.springFramework.service.QuestionService;
import ru.otus.springFramework.service.StudentService;

public class Application {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");

        StudentService studentService = context.getBean(StudentService.class);
        QuestionService questionService = context.getBean(QuestionService.class);
        Student one = studentService.createStudent();
        questionService.askQuestion(one);
        System.out.println(one);
    }
}