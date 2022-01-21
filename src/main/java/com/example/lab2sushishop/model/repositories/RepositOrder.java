package com.example.lab2sushishop.model.repositories;

import com.example.lab2sushishop.model.Entity;
import com.example.lab2sushishop.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Repository
public class RepositOrder implements Repositor{

    private final static String GET_ALL_ORDERS = "select * from orders order by id";
    private final static String GET_ORDER_BY_ID = "select * from orders where id=?";
    private final static String DELETE_ORDER_BY_ID = "delete from orders where id=?";
    private final static String ADD_NEW_ORDER = "insert into orders (product_ID, cart_ID, total_price_uah, quantity) values (?, ?, ?, ?)";


    private final JdbcTemplate jdbcTemplate;


    @Autowired
    public RepositOrder(JdbcTemplate jdbcTemplate) {
              this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<?> getList() {
        return jdbcTemplate.query(GET_ALL_ORDERS, new BeanPropertyRowMapper<>(Order.class));
    }

    @Override
    public void addNew(Entity entity) {
        Order order = (Order) entity;
        jdbcTemplate.update(ADD_NEW_ORDER,
                order.getProduct_ID(),
                order.getCart_ID(),
                order.getTotal_price_uah(),
                order.getQuantity());
    }

    @Override
    public void update(Entity entity) {
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update(DELETE_ORDER_BY_ID, id);
    }

    @Override
    public Entity show(int id) {
        return jdbcTemplate.queryForObject(GET_ORDER_BY_ID, new BeanPropertyRowMapper<>(Order.class), id);
    }
}
