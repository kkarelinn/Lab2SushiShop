package com.example.lab2sushishop.model.repositories;

import com.example.lab2sushishop.model.Entity;
import com.example.lab2sushishop.model.Product;
import com.example.lab2sushishop.model.base.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RepositProduct implements Repositor{

   private final Base base;

    @Autowired
    public RepositProduct(Base base) {
        this.base = base;
        base.setProductList(new ArrayList<>());
        base.insertProd(new Product("Filadelfia set", "In Filadelfia many good ingridients for exc.people", getNowDate(), 3.58));
        base.insertProd(new Product("California roll set", "SOme description for California", getNowDate(), 5.40));
        base.insertProd(new Product("Cheese bolls", "SOme description for Cheese", getNowDate(), 0.65));
    }


    @Override
    public List<Entity> getList() {
        return base.getProductList();
    }

    @Override
    public void addNew(Entity entity) {
        Product product = (Product) entity;
        if (product.getDate() == null) product.setDate(getNowDate());
        base.insertProd(product);
    }

    @Override
    public Entity show(int id) {
      return base.findProduct(id);
    }

    @Override
    public void update(Entity entity) {
        Product product = (Product) entity;
        product.setDate(getNowDate());
        base.updateProd(product);
    }

    @Override
    public void delete(int id) {
        base.removeProd(id);
    }


}
