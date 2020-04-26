package ru.otus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import ru.otus.dao.BookRepository;
import ru.otus.model.Book;

@EnableMongoRepositories
@SpringBootApplication

public class MySpringBootApp {

    public static void main(String[] args) {
        SpringApplication.run(MySpringBootApp.class, args);
    }


}


