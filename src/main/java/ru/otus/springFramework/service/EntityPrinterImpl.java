package ru.otus.springFramework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.springFramework.domain.Question;
import ru.otus.springFramework.domain.Student;

import java.util.Iterator;

@Service
public class EntityPrinterImpl implements EntityPrinter {
    private final MessageService messageService;

    @Autowired
    public EntityPrinterImpl(MessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    public String printStudent(Student student) {
        return messageService.getMessage("student") +
                " " +
                student.getName() +
                " " +
                student.getSurname() +
                ". " +
                messageService.getMessage("answered") +
                " " +
                student.getCountOfRightAnswers();
    }

    @Override
    public String printQuestion(Question question) {
        StringBuilder sb = new StringBuilder();
        sb.append(question.getTextOfQuestion() + "\n" + messageService.getMessage("varOfAnswers"));
        Iterator iterator = question.getAnswers().iterator();

        while (iterator.hasNext()){
            String answer = (String) iterator.next();
            sb.append("\n" + answer);
        }
        return sb.toString();
    }
}