import domain.Student;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.FileService;
import service.StudentService;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");

        StudentService studentService = context.getBean(StudentService.class);
        FileService fileService = context.getBean(FileService.class);

        Student one = studentService.createStudent();
        one.checkAnswers(one.askQuestions(fileService.readQuestions()), fileService.readAnswers());
        System.out.println(one);
    }
}