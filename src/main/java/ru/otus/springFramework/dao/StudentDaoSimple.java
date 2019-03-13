package ru.otus.springFramework.dao;

import ru.otus.springFramework.domain.Student;

import java.util.Scanner;

public class StudentDaoSimple implements StudentDao {
    public Student createStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите своё имя: ");
        String name = scanner.nextLine();
        System.out.println("Введите свою фамилию: ");
        String surname = scanner.nextLine();
        return new Student(name, surname);
    }
}