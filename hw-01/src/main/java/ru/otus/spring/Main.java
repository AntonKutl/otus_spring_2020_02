package ru.otus.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.spring.service.QuestionsService;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        QuestionsService service=context.getBean(QuestionsService.class);
        service.beginTest();
        context.close();
    }
}
