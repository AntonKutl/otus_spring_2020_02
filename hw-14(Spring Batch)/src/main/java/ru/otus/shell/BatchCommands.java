package ru.otus.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.service.MigrationBatchService;


@RequiredArgsConstructor
@ShellComponent
public class BatchCommands {

    private final MigrationBatchService batchService;

    @ShellMethod(value = "Migrate data to Mongo", key = {"migrate", "m"})
    public void migrate() {
        batchService.launchJob();
    }
}
