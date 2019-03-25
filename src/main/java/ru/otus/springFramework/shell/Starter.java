package ru.otus.springFramework.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;
import ru.otus.springFramework.domain.Student;
import ru.otus.springFramework.service.QuizService;
import ru.otus.springFramework.service.StudentService;

@ShellComponent
public class Starter {
    private final QuizService quizService;
    private final StudentService studentService;
    private Student newStudent;
    private boolean isLoggedIn;

    @Autowired
    public Starter(QuizService quizService, StudentService studentService){
        this.quizService = quizService;
        this.studentService = studentService;
    }

    @ShellMethod("Login student")
    public void login(){
        newStudent = studentService.createStudent();
        isLoggedIn = true;
    }

    @ShellMethodAvailability("startAvailability")
    @ShellMethod("Start Quiz")
    public void start(){
        quizService.startTest(newStudent);
    }

    public Availability startAvailability(){
        return isLoggedIn ? Availability.available() : Availability.unavailable("you are not login");
    }
}