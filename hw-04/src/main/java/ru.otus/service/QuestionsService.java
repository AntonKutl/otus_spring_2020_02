package ru.otus.service;

import java.io.IOException;

public interface QuestionsService {
    void beginTest() throws IOException;
    String viewTestResults();
    boolean isTheTestPassed();
}
