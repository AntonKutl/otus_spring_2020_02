package spring.dao;

import spring.domane.Questions;

import java.io.IOException;
import java.util.List;

public interface CSVDao {
    List<Questions> questions() throws IOException;
}
