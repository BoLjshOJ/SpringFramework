package ru.otus.springFramework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.otus.springFramework.config.YamlProps;
import ru.otus.springFramework.service.QuizService;

@SpringBootApplication
@EnableConfigurationProperties(YamlProps.class)
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args).getBean(QuizService.class).startTest();
    }
}