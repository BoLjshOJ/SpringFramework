package ru.otus.springFramework.service;

import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class IOServiceImpl implements IOService{
    Scanner sc = new Scanner(System.in);

    @Override
    public String getStringFromSonsole() {
        return sc.nextLine();
    }

    @Override
    public int getIntFromConsole() {
        return sc.nextInt();
    }
}