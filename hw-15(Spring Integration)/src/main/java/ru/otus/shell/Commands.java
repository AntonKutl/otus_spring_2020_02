package ru.otus.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.service.OrderService;
import ru.otus.service.OrderServiceImpl;

import java.io.IOException;

@RequiredArgsConstructor
@ShellComponent
public class Commands {

    private final OrderService orderService;

    @ShellMethod(value = "Order creation", key = {"order", "o"})
    public void migrate() throws IOException {
        orderService.processOrder();
    }
}
