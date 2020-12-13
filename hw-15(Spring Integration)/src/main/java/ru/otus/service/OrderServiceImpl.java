package ru.otus.service;

import org.springframework.stereotype.Service;
import ru.otus.domain.Item;
import ru.otus.domain.OrderItem;
import ru.otus.integration.ItemGateway;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final ItemGateway itemGateway;

    public OrderServiceImpl(ItemGateway itemGateway) {
        this.itemGateway = itemGateway;
    }

    @Override
    public void processOrder() throws IOException {
        List<OrderItem> list=new ArrayList<>();
        OrderItem orderItem=new OrderItem();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите название товара");
        orderItem.setItemName(reader.readLine());
        list.add(orderItem);
        list=null;
        List<Item> item=itemGateway.processOrder(list);
        System.out.println("Куплен товар: "+item);
    }
}
