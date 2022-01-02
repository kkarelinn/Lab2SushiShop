package com.example.lab2sushishop.model.repositories;

import com.example.lab2sushishop.model.Entity;
import com.example.lab2sushishop.model.base.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RepositOrder implements Repositor{

    private final Base base;

    @Autowired
    public RepositOrder(Base base) {
        //no any new order at start
        this.base = base;
        base.setOrderList(new ArrayList<>());
    }
    @Override
    public List<?> getList() {
        return base.getOrderList();
    }

    @Override
    public void addNew(Entity entity) {

    }

    @Override
    public void update(Entity entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Entity show(int id) {
        return null;
    }
}
