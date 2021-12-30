package com.example.lab2sushishop.model.repositories;

import com.example.lab2sushishop.model.Category;
import com.example.lab2sushishop.model.Entity;
import com.example.lab2sushishop.model.base.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class RepositCategory implements Repositor{

    private final Base base;
    @Autowired
    public RepositCategory(Base base) {
        this.base = base;
        base.setCategoryList(new ArrayList<>());
        base.insertCat(new Category("setts", "Sett`s group", getNowDate()));
        base.insertCat(new Category("rolls", "Roll`s group", getNowDate()));
        base.insertCat(new Category("drinks", "Juice and water", getNowDate()));

    }

    @Override
    public List<Entity> getList() {
        return base.getCategoryList();
    }

    @Override
    public void addNew(Entity entity) {
        Category category = (Category) entity;
        if (category.getDate() == null) category.setDate(getNowDate());
        base.insertCat(category);
    }

    @Override
    public void update(Entity entity) {
        Category category = (Category) entity;
        category.setDate(getNowDate());
        base.updateCat(category);
    }

    @Override
    public void delete(int id) {
        base.removeCat(id);
    }

    @Override
    public Entity show(int id) {
        return base.findCat(id);
    }

}
