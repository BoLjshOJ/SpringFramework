package ru.otus.springFramework.dao;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.otus.springFramework.domain.Question;
import ru.otus.springFramework.service.MessageService;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class QuestionDaoImpl implements QuestionDao {
    private List<Question> questions;
    private final MessageService messageService;
    private final String filename;

    @Autowired
    public QuestionDaoImpl(MessageService messageService, @Value("${filename}") String filename) {
        this.messageService = messageService;
        this.filename = String.format("CSV/%s_%s.csv", filename, messageService.getLocale().getLanguage());
    }

    public void initQuestionsFromCSV(){
        this.questions = new ArrayList<>();
        try {
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(filename);
            CSVParser parser = (new CSVParserBuilder()).withSeparator(';').build();
            CSVReader reader = (new CSVReaderBuilder(new InputStreamReader(inputStream))).withSkipLines(1).withCSVParser(parser).build();
            reader.readAll().forEach(this::createAndAddQuestion);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private void createAndAddQuestion(String[] row) {
        if (row == null || row.length < 2){
            throw new IllegalArgumentException("Array length < 2 or null");
        }
        String question = row[0];
        List<String> answers = Arrays.asList(row[1], row[2], row[3], row[4]);
        int numberOfRightAnswer = Integer.parseInt(row[5]);
        this.questions.add(new Question(question, answers, numberOfRightAnswer, messageService));
    }

    public List<Question> getQuestions() {
        if (this.questions == null){
            this.initQuestionsFromCSV();
        }
        return questions;
    }
}