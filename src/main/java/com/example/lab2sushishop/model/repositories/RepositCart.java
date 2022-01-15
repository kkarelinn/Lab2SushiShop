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

    private final static String GET_ALL_CARTS = "select * from carts order by id";
    private final static String GET_ALL_PRODUCTS = "select * from products order by id";
    private final static String GET_ALL_CLIENTS = "select * from clients order by id";
    private final static String GET_CART_BY_ID = "select * from carts where id=?";
    private final static String DELETE_CART_BY_ID = "delete from carts where id=?";
    private final static String DELETE_ORDERS_BY_CART_ID = "delete from orders where cart_ID=?";
    private final static String UPDATE_CART_BY_ID = "update carts set user_id=?, client_ID=?, totalprice_uah=?, deliveryaddress=?, status=? where id=?";
    private final static String ADD_NEW_ORDER = "insert into orders (product_ID, cart_ID, total_price_uah, quantity) values (?, ?, ?, ?)";
    private final static String ADD_NEW_CART = "insert into carts (user_id, client_ID, totalprice_uah, date, deliveryaddress, status) values (?, ?, ?, ?, ?, ?)";
    private final static String GET_CLIENT_BY_ID = "select * from clients where id=?";
    private final static String GET_PRODUCT_BY_ID = "select * from products where id=?";
    private final static String GET_CATEGORY_BY_ID = "select * from category where id=?";
    private static final int DEFAULT_CLIENT = 1;

    private final JdbcTemplate jdbcTemplate;


    @Autowired
    public RepositCart(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addNewOrder(Entity entity) {
        Order order = (Order) entity;
        jdbcTemplate.update(ADD_NEW_ORDER,
                order.getProduct_ID(),
                order.getCart_ID(),
                order.getTotal_price_uah(),
                order.getQuantity());
    }

    public List<Product> getProdList() {
        List<Product> list = jdbcTemplate.query(GET_ALL_PRODUCTS, new BeanPropertyRowMapper<>(Product.class));
        for (Product product : list) {
            product.setCategory(getCatById(product.getCategory_id()));
        }
        return list;
    }

    public Category getCatById(int cat_id) {
        return (cat_id == 0) ? null : jdbcTemplate.queryForObject(GET_CATEGORY_BY_ID, new BeanPropertyRowMapper<>(Category.class), cat_id);
    }

    public Product getProdById(int id) {
        if (id == 0) return null;
        Product product = jdbcTemplate.queryForObject(GET_PRODUCT_BY_ID, new BeanPropertyRowMapper<>(Product.class), id);
        product.setLinkProduct(putLink(product.getLinkprod_id()));
        return product;
    }

    private Product putLink(int id) {
        if (id == 0) return null;
        return jdbcTemplate
                .queryForObject(GET_PRODUCT_BY_ID, new BeanPropertyRowMapper<>(Product.class), id);
    }

    public int getLastCartID() {
        return getList().stream().mapToInt(c -> ((Cart) c).getID()).max().orElse(0);
    }

    public Client getClient(int client_ID) {
        int client = (client_ID == 0) ? DEFAULT_CLIENT : client_ID;
        return jdbcTemplate.queryForObject(GET_CLIENT_BY_ID, new BeanPropertyRowMapper<>(Client.class), client);
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
        return jdbcTemplate.query(GET_ALL_CLIENTS, new BeanPropertyRowMapper<>(Client.class));
    }
}
