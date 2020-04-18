package ru.otus.service;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.configs.YamlProps;
import ru.otus.dao.CSVDao;
import ru.otus.model.Questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Locale;

@Service
public class QuestionsServiceImpl implements QuestionsService {

    private  final YamlProps yamlProps;
    private final CSVDao daoCSV;
    private final MessageSource messageSource;
    private static String name;
    private static String surname;
    private static int counter;
    private static boolean testException=false;

    public QuestionsServiceImpl(YamlProps yamlProps, CSVDao daoCSV, MessageSource messageSource) {
        this.yamlProps = yamlProps;
        this.daoCSV = daoCSV;
        this.messageSource = messageSource;
    }

    @Override
    public void beginTest() throws IOException {
        testException=true;
        counter = 0;
        List<Questions> list = daoCSV.questions();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(messageSource.getMessage("question.name",null, Locale.forLanguageTag(yamlProps.getLocal())));
        name = reader.readLine();
        System.out.println(messageSource.getMessage("question.surname",null,Locale.forLanguageTag(yamlProps.getLocal())));
        surname = reader.readLine();
        System.out.println(messageSource.getMessage("question.questions",null,Locale.forLanguageTag(yamlProps.getLocal())));
        for (Questions question : list) {
            String temp;
            System.out.println(question.getQuestion());
            temp = reader.readLine();
            if (question.getAnswer().equals(temp)) {
                counter++;
            }
        }
    }

    @Override
    public String viewTestResults() {
        return name + " " + surname + messageSource.getMessage("question.answers",new Integer[]{counter}, Locale.forLanguageTag(yamlProps.getLocal()));
    }

    @Override
    public boolean isTheTestPassed() {
        return testException;
    }
}
