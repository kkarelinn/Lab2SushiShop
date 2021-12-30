package com.example.lab2sushishop.model.base;

import com.example.lab2sushishop.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Base {

    private static int CAT_COUNT;
    private static int PROD_COUNT;
    private static int USER_COUNT;
    private static int CLIENT_COUNT;
    private List<Entity> productList;
    private List<Entity> categoryList;
    private List<Entity> clientList;
    private List<Entity> userList;

    @Autowired
    public Base(List<Entity> productList) {
     super();
    }

    public List<Entity> getProductList() {
        return productList;
    }

    public void setProductList(List<Entity> productList) {
        this.productList = productList;
    }

    public List<Entity> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Entity> categoryList) {
        this.categoryList = categoryList;
    }

    public List<Entity> getClientList() {
        return clientList;
    }

    public void setClientList(List<Entity> clientList) {
        this.clientList = clientList;
    }

    public List<Entity> getUserList() {
        return userList;
    }

    public void setUserList(List<Entity> userList) {
        this.userList = userList;
    }

    //Products
    public void insertProd(Entity entity){
       entity.setID(++PROD_COUNT);
        productList.add(entity);
    }
    public void updateProd(Product product){

        int id = productList.indexOf(findProduct(product.getID()));
        productList.set(id, product);
    }
    public Entity findProduct(int id){
        return productList.stream().filter(p->p.getID()==id).findFirst().orElse(null);
    }
    public void removeProd(int id){
      productList.removeIf(p->p.getID()==id);
    }

    //Categories
    public void insertCat(Category category){
        category.setID(++CAT_COUNT);
       categoryList.add(category);
    }
    public void updateCat(Category category){
        int id = categoryList.indexOf(findCat(category.getID()));
        categoryList.set(id, category);
    }
    public Entity findCat(int id){
        return categoryList.stream().filter(c->c.getID()==id).findFirst().orElse(null);
    }
    public void removeCat(int id){
        categoryList.removeIf(c->c.getID()==id);
    }

    //Users
    public void insertUser(Entity entity){
        entity.setID(++USER_COUNT);
        userList.add(entity);
    }
    public void updateUser(Entity entity){
        int id = userList.indexOf(findUser(entity.getID()));
        userList.set(id, entity);
    }
    public Entity findUser(int id){
    return userList.stream().filter(u->u.getID()==id).findFirst().orElse(null);
    }
    public void removeUser(int id){
        userList.removeIf(u->u.getID()==id);
    }

    //Clients
    public void insertClient(Entity entity){
        entity.setID(++CLIENT_COUNT);
        clientList.add(entity);
    }
    public void updateClient(Entity entity){
        int id = clientList.indexOf(findClient(entity.getID()));
        clientList.set(id, entity);
    }
    public Entity findClient(int id){
        return clientList.stream().filter(cl->cl.getID()==id).findFirst().orElse(null);
    }
    public void removeClient(int id){
        clientList.removeIf(cl->cl.getID()==id);
    }

}
