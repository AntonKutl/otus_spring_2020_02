package spring.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import spring.dao.CSVDao;
import spring.domane.Questions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

@Service
public class QuestionsServiceImpl implements QuestionsService {

    @Value("${user.region}")
    private String local;

    private final CSVDao daoCSV;
    private final MessageSource messageSource;
    private static String name;
    private static String surname;
    private static int counter = 0;

    @Autowired
    public QuestionsServiceImpl(CSVDao daoCSV, MessageSource messageSource) {
        this.daoCSV = daoCSV;
        this.messageSource = messageSource;
    }

    @Override
    public void beginTest() throws IOException {
        List<Questions> list = daoCSV.questions();
        Scanner in = new Scanner(System.in);
        System.out.println(messageSource.getMessage("question.name",null, Locale.forLanguageTag(local)));
        name = in.next();
        System.out.println(messageSource.getMessage("question.surname",null,Locale.forLanguageTag(local)));
        surname = in.next();
        System.out.println(messageSource.getMessage("question.questions",null,Locale.forLanguageTag(local)));
        for (Questions question : list) {
            String temp;
            System.out.println(question.getQuestion());
            temp = in.next();
            if (question.getAnswer().equals(temp)) {
                counter++;
            }
        }
        System.out.println(name + " " + surname + messageSource.getMessage("question.answers",new Integer[]{counter}, Locale.forLanguageTag(local)));
    }
}
