package spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import spring.service.QuestionsService;

import java.io.IOException;

@Configuration
@ComponentScan

public class Main {

    public static void main(String[] args) throws IOException {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Main.class);


        QuestionsService service = context.getBean(QuestionsService.class);
        service.beginTest();
    }
}
