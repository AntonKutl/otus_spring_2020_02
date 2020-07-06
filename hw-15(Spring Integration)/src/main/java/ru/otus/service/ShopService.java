package ru.otus.service;

import org.springframework.stereotype.Service;
import ru.otus.domain.Item;
import ru.otus.domain.OrderItem;

@Service
public class ShopService {

    public Item process(OrderItem orderItem) throws InterruptedException {
        Thread.sleep(3000);
        return Item.builder().name(orderItem.getItemName()).build();
    }

}
