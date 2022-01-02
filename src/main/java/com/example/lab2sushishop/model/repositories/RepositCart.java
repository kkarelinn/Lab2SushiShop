package com.example.lab2sushishop.model.repositories;

import com.example.lab2sushishop.model.Client;
import com.example.lab2sushishop.model.Entity;
import com.example.lab2sushishop.model.Order;
import com.example.lab2sushishop.model.base.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RepositCart implements Repositor{

    private final Base base;

    @Autowired
    public RepositCart(Base base) {
        //no any new cart at start
        this.base = base;
        base.setOrderList(new ArrayList<>());
        base.setCartList(new ArrayList<>());
    }

    public void addNewOrder(Entity entity) {
        base.insertOrder(entity);
    }

    public List<String[]> getListProducts() {
        return base.getProdsWithCatString();
    }
    public List<String[]> getLinesFromCart(int cart_ID) {
        List<String[]> cartStr = new ArrayList<>();
        List<Entity> orders = base.getOrderListFromCart(cart_ID);
        for (Entity ent : orders) {
            Order ord = (Order)ent;
            String[] str = base.getProdWithCat(ord.getProduct_ID());
            String[] full = new String[str.length + 2];
            System.arraycopy(str, 0, full, 0, str.length);
            full[full.length - 2] = ord.getQuantity() + "";
            full[full.length - 1] = ord.getTotalOrdPriceUAH() + "";
            cartStr.add(full);
        }
        return cartStr;

    }
    public Entity getClient(int client_ID){
       return base.getClientList().stream().filter(c->c.getID()==client_ID).findFirst().orElse(new Client());
    }

    public String[] getProd(int prodID) {
        return base.getProdWithCat(prodID);
    }

    @Override
    public List<?> getList() {
        return base.getCartList();
    }

    @Override
    public void addNew(Entity entity) {
        entity.setDate(getNowDate());
        base.insertCart(entity);
    }

    @Override
    public void update(Entity entity) {
        entity.setDate(getNowDate());
        base.updateCart(entity);
    }

    @Override
    public void delete(int id) {
        base.removeCart(id);
    }

    @Override
    public Entity show(int id) {
        return base.findProduct(id);
    }

      public int getLastCartID() {
        return base.getLastCartID();
    }



}
