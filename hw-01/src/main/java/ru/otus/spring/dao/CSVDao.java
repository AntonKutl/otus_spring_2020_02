package ru.otus.spring.dao;

import ru.otus.spring.domane.Questions;

import java.io.IOException;
import java.util.List;

public interface CSVDao {

    List<Questions> questions () throws IOException;
}
