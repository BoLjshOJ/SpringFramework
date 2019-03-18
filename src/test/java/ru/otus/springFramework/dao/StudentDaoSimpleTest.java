package ru.otus.springFramework.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.springFramework.domain.Student;
import ru.otus.springFramework.service.MessageService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

@DisplayName("Student")
class StudentDaoSimpleTest {
    private MessageService messageService;

    @DisplayName("correctly created")
    @Test
    void createStudent() {
        messageService = mock(MessageService.class);
        Student one = new Student("Petr", "Petrov", messageService);
        assertThat(one.getName()).isEqualToIgnoringCase("petr");
        assertThat(one.getSurname()).isEqualToIgnoringCase("petrov");
    }
}