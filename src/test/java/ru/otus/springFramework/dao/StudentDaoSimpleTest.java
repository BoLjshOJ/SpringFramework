package ru.otus.springFramework.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.otus.springFramework.domain.Student;
import ru.otus.springFramework.service.MessageService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentDaoSimpleTest {
    private MessageService messageService;

    @Test
    public void createStudent() {
        messageService = mock(MessageService.class);
        Student student = new Student("name", "surname", messageService);
        assertThat(student.getName()).isEqualToIgnoringCase("name");
        assertThat(student.getSurname()).isEqualToIgnoringCase("surname");
    }
}