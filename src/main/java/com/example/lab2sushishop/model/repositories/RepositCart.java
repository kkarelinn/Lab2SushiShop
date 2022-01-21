package com.example.lab2sushishop.model.repositories;

import com.example.lab2sushishop.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import java.util.List;

@Component
@Repository
public class RepositCart implements Repositor {

    private static final int DEFAULT_CLIENT = 1;
    private final static String GET_ALL_CARTS = "select * from carts order by id";
    private final static String GET_CART_BY_ID = "select * from carts where id=?";
    private final static String DELETE_CART_BY_ID = "delete from carts where id=?";
    private final static String DELETE_ORDERS_BY_CART_ID = "delete from orders where cart_ID=?";
    private final static String UPDATE_CART_BY_ID = "update carts set user_id=?, client_ID=?, totalprice_uah=?, deliveryaddress=?, status=? where id=?";
    private final static String ADD_NEW_CART = "insert into carts (user_id, client_ID, totalprice_uah, date, deliveryaddress, status) values (?, ?, ?, ?, ?, ?)";

    private final JdbcTemplate jdbcTemplate;
    private final RepositProduct repositProduct;
    private final RepositClient repositClient;
    private final RepositOrder repositOrder;
    private final RepositCategory repositCategory;

    @Autowired
    public RepositCart(JdbcTemplate jdbcTemplate, RepositProduct repositProduct, RepositClient repositClient, RepositOrder repositOrder, RepositCategory repositCategory) {
        this.jdbcTemplate = jdbcTemplate;
        this.repositProduct = repositProduct;
        this.repositClient = repositClient;
        this.repositOrder = repositOrder;
        this.repositCategory = repositCategory;
    }

    public void addNewOrder(Entity entity) {
      repositOrder.addNew(entity);
    }

    public List<Product> getProdList() {
        List<Product> list = repositProduct.getList();
        for (Product product : list) {
            product.setCategory(getCatById(product.getCategory_id()));
        }
        return list;
    }

    public Category getCatById(int cat_id) {
        return (cat_id == 0) ? null : repositCategory.show(cat_id);
    }

    public Product getProdById(int id) {
        if (id == 0) return null;
        return repositProduct.show(id);
    }

    public int getLastCartID() {
        return getList().stream().mapToInt(c -> ((Cart) c).getID()).max().orElse(0);
    }

    public Client getClient(int client_ID) {
        int clientID = (client_ID == 0) ? DEFAULT_CLIENT : client_ID;
        return (Client) repositClient.show(clientID);
    }

    @Override
    public List<?> getList() {
        return jdbcTemplate.query(GET_ALL_CARTS, new BeanPropertyRowMapper<>(Cart.class));
    }

    @Override
    public void addNew(Entity entity) {
        Cart cart = (Cart) entity;
        cart.setDate(getNowDate());
        if (cart.getUser_ID() == 0) cart.setUser_ID(1);

        jdbcTemplate.update(ADD_NEW_CART,
                cart.getUser_ID(),
                cart.getClient_ID(),
                cart.getTotalPrice_uah(),
                cart.getDate(),
                cart.getDeliveryAddress(),
                cart.getStatus());
    }

    @Override
    public void update(Entity entity) {
        Cart cart = (Cart) entity;
        cart.setDate(getNowDate());

        jdbcTemplate.update(UPDATE_CART_BY_ID,
                cart.getUser_ID(),
                cart.getClient_ID(),
                cart.getTotalPrice_uah(),
                cart.getDeliveryAddress(),
                cart.getStatus(),
                cart.getID());
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update(DELETE_ORDERS_BY_CART_ID, id);
        jdbcTemplate.update(DELETE_CART_BY_ID, id);
    }

    @Override
    public Entity show(int id) {
        return jdbcTemplate.queryForObject(GET_CART_BY_ID, new BeanPropertyRowMapper<>(Cart.class), id);
    }

    public List<?> getClientList() {
        return repositClient.getList();
    }
}
