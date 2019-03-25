package ru.otus.springFramework.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import ru.otus.springFramework.domain.Student;
import ru.otus.springFramework.service.IOService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentDaoSimpleTest {

    @Autowired
    private StudentDao studentDao;
    @MockBean
    private IOService ioService;

    @Test
    public void createStudent() {
        Student studentExpected = new Student("name", "surname");
        given(ioService.getStringFromSonsole()).willReturn(studentExpected.getName(), studentExpected.getSurname());
        Student studentActual = studentDao.createStudent();
        assertThat(studentActual.getName()).isEqualTo(studentExpected.getName());
        assertThat(studentActual.getSurname()).isEqualTo(studentExpected.getSurname());
    }
}