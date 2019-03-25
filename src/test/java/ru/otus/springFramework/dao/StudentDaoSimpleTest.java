package ru.otus.springFramework.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.otus.springFramework.domain.Student;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentDaoSimpleTest {

    @Test
    public void createStudent() {
        Student student = new Student("name", "surname");
        assertThat(student.getName()).isEqualToIgnoringCase("name");
        assertThat(student.getSurname()).isEqualToIgnoringCase("surname");
    }
}