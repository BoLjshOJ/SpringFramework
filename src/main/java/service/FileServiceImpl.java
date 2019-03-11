package service;

import dao.FileDao;

import java.util.List;

public class FileServiceImpl implements FileService {
    private final static String PATH_OF_QUESTION_FILE = "C:\\Users\\User\\Desktop\\Java\\Otus\\SpringFramework\\src\\main\\resources\\CSV\\question.csv";
    private final static String PATH_OF_ANSWERS_FILE = "C:\\Users\\User\\Desktop\\Java\\Otus\\SpringFramework\\src\\main\\resources\\CSV\\answers.csv";
    private final FileDao fileDao;

    public FileServiceImpl(FileDao fileDao) {
        this.fileDao = fileDao;
    }


    public List<String> readQuestions() {
        return fileDao.readFile(PATH_OF_QUESTION_FILE);
    }

    public List<String> readAnswers() {
        return fileDao.readFile(PATH_OF_ANSWERS_FILE);
    }
}