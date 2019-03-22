package ru.otus.springFramework.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.springFramework.service.QuizService;

@ShellComponent
public class Starter {
    private final QuizService quizService;

    @Autowired
    public Starter(QuizService quizService){
        this.quizService = quizService;
    }

    @ShellMethod("Start Quiz")
    public void start(){
        quizService.startTest();
    }
}