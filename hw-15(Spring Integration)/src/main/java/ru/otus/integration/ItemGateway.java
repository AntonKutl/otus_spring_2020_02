package ru.otus.integration;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import ru.otus.domain.Item;
import ru.otus.domain.OrderItem;

import java.util.List;

@MessagingGateway(errorChannel = "errorChannel")
public interface ItemGateway {

    @Gateway(requestChannel = "ordersChannel", replyChannel = "goodsChannel")
    List<Item> processOrder(List<OrderItem> items);
}
