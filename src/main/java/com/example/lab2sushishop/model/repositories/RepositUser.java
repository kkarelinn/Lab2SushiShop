package com.example.lab2sushishop.model.repositories;

import com.example.lab2sushishop.model.Category;
import com.example.lab2sushishop.model.Entity;
import com.example.lab2sushishop.model.User;
import com.example.lab2sushishop.model.UserAccess;
import com.example.lab2sushishop.model.base.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class RepositUser implements Repositor{

    private final Base base;
    @Autowired
    public RepositUser(Base base) {
        this.base = base;
        base.setUserList(new ArrayList<>());
        base.insertUser(new User("Artem Ivanov", -1, UserAccess.MANAGER));
        base.insertUser(new User("Ivan Dorn", 1, UserAccess.EMPLOYEE));
        base.insertUser(new User("Semen Golovin", 1, UserAccess.ADMIN));

    }

    @Override
    public List<Entity> getList() {
        return base.getUserList();
    }

    @Override
    public void addNew(Entity entity) {
      base.insertUser((User) entity);
    }

    @Override
    public void update(Entity entity) {
        User user = (User) entity;
        base.updateUser(user);
    }

    @Override
    public void delete(int id) {
        base.removeUser(id);
    }

    @Override
    public Entity show(int id) {
        return base.findUser(id);
    }
}
