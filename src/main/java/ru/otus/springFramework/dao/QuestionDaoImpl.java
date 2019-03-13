package ru.otus.springFramework.dao;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import ru.otus.springFramework.domain.Question;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuestionDaoImpl implements QuestionDao {
    private List<Question> questions;
    private String pathForQuestions;

    public QuestionDaoImpl(String pathForQuestions) {
        this.pathForQuestions = pathForQuestions;
    }

    public void initQuestionsFromCSV(){
        this.questions = new ArrayList<>();
        try {
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(pathForQuestions);
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
        this.questions.add(new Question(question, answers, numberOfRightAnswer));
    }

    public List<Question> getQuestions() {
        if (this.questions == null){
            this.initQuestionsFromCSV();
        }
        return questions;
    }
}