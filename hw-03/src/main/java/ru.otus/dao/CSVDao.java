package ru.otus.dao;

import ru.otus.model.Questions;
import java.io.IOException;
import java.util.List;

public interface CSVDao {
    List<Questions> questions() throws IOException;
}
