package com.example.lab2sushishop.services;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class NasdaqService implements StockService{
    @Override
    public String getId() {
        return "Nasdaq";
    }

    @Override
    public float getExchangeRate(String id, LocalDateTime time) {
        System.out.println("Nasdaq works - id:" +id);


        return 0;
    }
}
