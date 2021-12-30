package com.example.lab2sushishop.model.repositories;

import com.example.lab2sushishop.model.Client;
import com.example.lab2sushishop.model.Entity;
import com.example.lab2sushishop.model.User;
import com.example.lab2sushishop.model.UserAccess;
import com.example.lab2sushishop.model.base.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RepositClient implements Repositor{
    private final Base base;

    @Autowired
    public RepositClient(Base base) {
        this.base = base;
        base.setClientList(new ArrayList<>());
        base.insertClient(new Client("Client1", "Ukraine, Sumy"));
        base.insertClient(new Client("Client2", "Ukraine, Dnepr"));
        base.insertClient(new Client("Client3", "Ukraine, Kyiv"));
    }
    @Override
    public List<Entity> getList() {
        return base.getClientList();
    }

    @Override
    public void addNew(Entity entity) {
        base.insertClient((Client)entity);
    }

    @Override
    public void update(Entity entity) {
        base.updateClient(entity);
    }

    @Override
    public void delete(int id) {
        base.removeClient(id);
    }

    @Override
    public Entity show(int id) {
        return base.findClient(id);
    }
}
