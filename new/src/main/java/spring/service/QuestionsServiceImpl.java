package spring.service;


import org.springframework.stereotype.Service;
import spring.dao.CSVDao;
import spring.domane.Questions;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

@Service
public class QuestionsServiceImpl implements QuestionsService {

    private final CSVDao daoCSV;
    private static String name;
    private static int counter = 0;

    public QuestionsServiceImpl(CSVDao daoCSV) {
        this.daoCSV = daoCSV;
    }

    @Override
    public void beginTest() throws IOException {
        List<Questions> list = daoCSV.questions();
        Scanner in = new Scanner(System.in);
        System.out.println("What's your name");
        name = in.next();
        for (Questions question : list) {
            String temp;
            System.out.println(question.getQuestion());
            temp = in.next();
            if (question.getAnswer().equals(temp)) {
                counter++;
            }
        }
        System.out.println(name + " "+counter+" the answer is correct");
    }
}
