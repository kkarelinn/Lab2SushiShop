package com.example.lab2sushishop.model.base;

import com.example.lab2sushishop.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class Base {

    private static int CAT_COUNT;
    private static int PROD_COUNT;
    private static int USER_COUNT;
    private static int CLIENT_COUNT;
    private static int ORDER_COUNT;
    private static int CART_COUNT;

    private List<Entity> productList;
    private List<Entity> categoryList;
    private List<Entity> clientList;
    private List<Entity> userList;
    private List<Entity> orderList;
    private List<Entity> cartList;

    public List<Entity> getOrderList() {
        return orderList;
    }
    public void setOrderList(List<Entity> orderList) {
        this.orderList = orderList;
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

    public List<Entity> getCartList() {
        return cartList;
    }
    public void setCartList(List<Entity> cartList) {
        this.cartList = cartList;
    }

    //Products
    public void insertProd(Entity entity){
       entity.setID(++PROD_COUNT);
        productList.add(entity);
    }
    public void updateProd(Entity entity){
        int id = productList.indexOf(findProduct(entity.getID()));
        productList.set(id, entity);
    }
    public Entity findProduct(int id){
        return productList.stream().filter(p->p.getID()==id).findFirst().orElse(null);
    }
    public void removeProd(int id){
      productList.removeIf(p->p.getID()==id);
    }
    public List<String[]> getProdsWithCatString() {
        List<String[]> ret = new ArrayList<>();
        for (Entity ent : getProductList()) {
            ret.add(getProdWithCat(((Product)ent).getID()));
        }
        return ret;

    }

    //Categories
    public void insertCat(Entity entity){
        entity.setID(++CAT_COUNT);
       categoryList.add(entity);
    }
    public void updateCat(Entity entity){
        int id = categoryList.indexOf(findCat(entity.getID()));
        categoryList.set(id, entity);
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

    //Orders
    public void insertOrder(Entity entity){
        entity.setID(++ORDER_COUNT);
        orderList.add(entity);
    }
    public void updateOrder(Entity entity){
        int id = orderList.indexOf(findOrder(entity.getID()));
        clientList.set(id, entity);
    }
    public Entity findOrder(int id){
        return orderList.stream().filter(o->o.getID()==id).findFirst().orElse(null);
    }
    public List<Entity> findOrdersByCartID(int cartID){
        return orderList.stream().filter(o->((Order)o).getCart_ID()==cartID).collect(Collectors.toList());
    }
    public void removeOrder(int id){
        orderList.removeIf(cl->cl.getID()==id);
    }


    //Carts
    public void insertCart(Entity entity){
        entity.setID(++CART_COUNT);
        cartList.add(entity);
        System.out.println("Now list carts are");
        System.out.println(getCartList());
    }
    public void updateCart(Entity entity){
        int id = cartList.indexOf(findCart(entity.getID()));
        cartList.set(id, entity);
    }
    public Entity findCart(int id){
        return cartList.stream().filter(crt->crt.getID()==id).findFirst().orElse(null);
    }
    public void removeCart(int id){
        cartList.removeIf(crt->crt.getID()==id);
    }
    public int getLastCartID() {
       return getCartList().stream().mapToInt(Entity::getID).max().orElse(0);
    }

    //queryMethods
    // LIST of QUERY prodID - prodTitle - prodDescr - catTitle
    public List<String[]> getProdsFromOrderList(List<Entity> orderList) {
        List<String[]> ret = new ArrayList<>();
        for (Entity ent : orderList) {
            ret.add(getProdWithCat(((Order)ent).getProduct_ID()));
        }
        return ret;

    }
    // 1 line QUERY prodID - prodTitle - prodDescr - prodPriceUSD - catTitle
    public String[] getProdWithCat(int prodID) {
       Product pr =  (Product)findProduct(prodID);
       if (pr==null) return null;
            StringBuilder line = new StringBuilder();
            line.append(pr.getID()).append('%');
            line.append(pr.getTitle()).append('%');
            line.append(pr.getDescription()).append('%');
            line.append(pr.getPriceUsd()).append('%');
            Category cat = (Category) findCat(pr.getCategory_ID());
            if (cat != null) {
                line.append(cat.getTitle());
            }
            String[] mass = line.toString().split("%");
//     System.out.println(Arrays.toString(mass));
            return mass;
        }


    public List<Entity> getOrderListFromCart(int cart_id) {
        return getOrderList().stream().filter(o->((Order) o).getCart_ID()==cart_id).collect(Collectors.toList());

    }
}
