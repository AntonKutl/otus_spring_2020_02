package spring.actuators;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;
import spring.dao.BookRepository;

@Component
public class MyHealthIndicator implements HealthIndicator {

    private final BookRepository bookRepository;

    public MyHealthIndicator(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Health health() {
        long book = bookRepository.count();
        if (book==0) {
            return Health.down()
                    .status(Status.DOWN)
                    .withDetail("message", "Караул!")
                    .build();
        } else {
            return Health.up().withDetail("message", "Ура, товарищи!").build();
        }
    }
}
