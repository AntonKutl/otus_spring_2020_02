package ru.otus.service;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface OrderService {
     void processOrder() throws IOException;
}
