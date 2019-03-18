package ru.otus.springFramework.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.otus.springFramework.domain.Student;
import ru.otus.springFramework.service.IOService;
import ru.otus.springFramework.service.MessageService;

@Component
public class StudentDaoSimple implements StudentDao {
    private MessageService messageService;
    private IOService ioService;

    @Autowired
    public StudentDaoSimple(MessageService messageService, IOService ioService) {
        this.messageService = messageService;
        this.ioService = ioService;
    }

    public Student createStudent() {
        System.out.println(messageService.getMessage("inputName"));
        String name = ioService.getStringFromSonsole();
        System.out.println(messageService.getMessage("inputSurname"));
        String surname = ioService.getStringFromSonsole();
        return new Student(name, surname, messageService);
    }
}