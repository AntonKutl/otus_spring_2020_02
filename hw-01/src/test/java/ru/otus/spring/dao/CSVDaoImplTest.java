package ru.otus.spring.dao;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.spring.domane.Questions;

import java.io.IOException;
import java.util.List;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("CSVDaoImplTest должен")
class CSVDaoImplTest {

    @Test
    @DisplayName("правильно считывать значения с файла CSV")
    void questions() throws IOException {
        CSVDao csvDao=new CSVDaoImpl("/questionsTest.scv");
        List<Questions> list=csvDao.questions();
        for (Questions question:list) {
            Assertions.assertEquals(question.getQuestion(),"один");
            Assertions.assertEquals(question.getAnswer(),"два");

        }

    }
}