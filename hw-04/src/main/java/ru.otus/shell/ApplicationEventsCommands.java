package ru.otus.shell;

import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;
import ru.otus.service.QuestionsService;

import java.io.IOException;

@ShellComponent
public class ApplicationEventsCommands {

    private final QuestionsService questionsService;

    public ApplicationEventsCommands(QuestionsService questionsService) {
        this.questionsService = questionsService;
    }

    @ShellMethod(key = {"test", "t"}, value = "Begin test")
    public void beginTest() throws IOException {
        questionsService.beginTest();
    }

    @ShellMethod(key = {"view","v"}, value = "View test results")
    @ShellMethodAvailability(value = "isTheTestPassed")
    public void viewTestResults() throws IOException {
        System.out.println(questionsService.viewTestResults());
    }

    private Availability isTheTestPassed() {
        return questionsService.isTheTestPassed()==false  ? Availability.unavailable("Pass test"): Availability.available();
    }

}
