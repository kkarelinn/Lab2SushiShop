package com.example.lab2sushishop.services;

import java.time.LocalDateTime;

public interface StockService {
    String getId();
    float getExchangeRate(String id, LocalDateTime time);

}
