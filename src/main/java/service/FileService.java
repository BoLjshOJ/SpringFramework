package service;

import java.util.List;

public interface FileService {
    List<String> readQuestions();
    List<String> readAnswers();
}