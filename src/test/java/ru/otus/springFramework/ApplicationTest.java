package ru.otus.springFramework;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.otus.springFramework.dao.QuestionDao;
import ru.otus.springFramework.dao.StudentDao;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Autowired
    private StudentDao studentDao;
    @Autowired
    private QuestionDao questionDao;

    @Test
    public void contextLoads() throws Exception {
        assertThat(studentDao).isNotNull();
    }
}