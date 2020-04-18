package ru.otus.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.otus.model.Questions;
import ru.otus.service.QuestionsService;

import java.io.IOException;
import java.util.List;


@DisplayName("CSVDaoImplTest должен")
@SpringBootTest
class CSVDaoImplTest {

    @Autowired
    CSVDao csvDao;

    @MockBean
    QuestionsService questionsService;

    @Test
    @DisplayName("правильно считывать значения с файла CSV")
    void questions() throws IOException {

        List<Questions> list = csvDao.questions();
        Assertions.assertEquals(list.get(0).getQuestion(), "Capital Of Italy?");
        Assertions.assertEquals(list.get(0).getAnswer(), "Rome");


    }
}