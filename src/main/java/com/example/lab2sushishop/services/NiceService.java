package com.example.lab2sushishop.services;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NiceService implements StockService{
    @Override
    public String getId() {
        return "Nyse";
    }

    @Override
    public float getExchangeRate(String id, LocalDateTime time) {
        System.out.println("Nyse works - id:" );
        return 0;
    }
}
