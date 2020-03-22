package ru.otus.dao;

import ru.otus.domane.Questions;
import java.io.IOException;
import java.util.List;

public interface CSVDao {
    List<Questions> questions() throws IOException;
}
