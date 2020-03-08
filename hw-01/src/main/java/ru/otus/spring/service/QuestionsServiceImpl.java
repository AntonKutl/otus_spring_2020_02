package ru.otus.spring.service;

import ru.otus.spring.dao.CSVDao;
import ru.otus.spring.domane.Questions;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class QuestionsServiceImpl implements QuestionsService {

    private final CSVDao dao;
    private static String name;
    private static String surname;
    private static int counter=0;

    public QuestionsServiceImpl(CSVDao dao) {
        this.dao = dao;
    }

    @Override
    public void beginTest() throws IOException {
        List<Questions> list=dao.questions();
        Scanner in = new Scanner(System.in);
        System.out.println("Введите имя:");
        name=in.next();
        System.out.println("Введите фамилию:");
        surname=in.next();
        System.out.println("Вопросы теста:");
        for (Questions question:list) {
            String temp;
            System.out.println(question.getQuestion());
            temp=in.next();
            if (question.getAnswer().equals(temp)){
                counter++;
            }

        }
        System.out.println(name+" "+surname+" Вы ответили на "+counter+" вопроса");

    }
}
