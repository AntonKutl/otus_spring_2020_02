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
    private static int counter = 0;

    public QuestionsServiceImpl(YamlProps yamlProps, CSVDao daoCSV, MessageSource messageSource) {
        this.yamlProps = yamlProps;
        this.daoCSV = daoCSV;
        this.messageSource = messageSource;
    }

    @Override
    public void beginTest() throws IOException {
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
        System.out.println(name + " " + surname + messageSource.getMessage("question.answers",new Integer[]{counter}, Locale.forLanguageTag(yamlProps.getLocal())));
    }
}
