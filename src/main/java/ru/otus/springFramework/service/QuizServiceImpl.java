package ru.otus.springFramework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.springFramework.domain.Student;

@Service
public class QuizServiceImpl implements QuizService {
    private final QuestionService questionService;
    private final MessageService messageService;
    private final EntityPrinter printer;

    @Autowired
    public QuizServiceImpl(
            QuestionService questionService,
            MessageService messageService,
            EntityPrinter printer
            ) {
        this.questionService = questionService;
        this.messageService = messageService;
        this.printer = printer;
    }

    @Override
    public void startTest(Student student) {
        System.out.println(messageService.getMessage("greetingMessage"));
        questionService.askQuestion(student);
        System.out.println(printer.printStudent(student));
    }
}