package ru.otus.springFramework.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.otus.springFramework.domain.Student;
import ru.otus.springFramework.service.MessageService;

import java.util.Scanner;
@Component
public class StudentDaoSimple implements StudentDao {
    private MessageService messageService;

    @Autowired
    public StudentDaoSimple(MessageService messageService) {
        this.messageService = messageService;
    }

    public Student createStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(messageService.getMessage("inputName"));
        String name = scanner.nextLine();
        System.out.println(messageService.getMessage("inputSurname"));
        String surname = scanner.nextLine();
        return new Student(name, surname, messageService);
    }
}