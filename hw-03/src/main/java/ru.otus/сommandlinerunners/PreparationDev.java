package ru.otus.сommandlinerunners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.otus.configs.YamlProps;
import ru.otus.service.QuestionsService;

import java.io.IOException;


@Component
public class PreparationDev implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(PreparationDev.class);

    private final YamlProps yamlProps;
    private final QuestionsService questionsService;

    public PreparationDev(YamlProps yamlProps, QuestionsService questionsService) {
        this.yamlProps = yamlProps;
        this.questionsService = questionsService;
    }


    @Override
    public void run(String... args) throws IOException {
        questionsService.beginTest();
    }
}
