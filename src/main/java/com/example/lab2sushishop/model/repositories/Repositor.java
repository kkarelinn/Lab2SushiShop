package com.example.lab2sushishop.model.repositories;

import com.example.lab2sushishop.model.Entity;
import com.example.lab2sushishop.model.Product;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public interface Repositor {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    List<?> getList();
    void addNew(Entity entity);
    void update(Entity entity);
    void delete(int id);
    Entity show(int id);
    default String getNowDate() {
        return LocalDateTime.now().format(formatter);
    }

}