package com.example.lab2sushishop.model.repositories;


import com.example.lab2sushishop.model.Client;
import com.example.lab2sushishop.model.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Repository
public class RepositClient implements Repositor {

    private final static String GET_ALL_CLIENTS = "select * from clients order by id";
    private final static String GET_CLIENT_BY_ID = "select * from clients where id=?";
    private final static String DELETE_CLIENT_BY_ID = "delete from clients where id=?";
    private final static String UPDATE_CLIENT_BY_ID = "update clients set fullname=?, address=? where id=?";
    private final static String ADD_NEW_CLIENT = "insert into clients (fullname, address) values (?, ?)";

    JdbcTemplate jdbcTemplate;

    @Autowired
    public RepositClient(JdbcTemplate jdbcTemplate) {
              this.jdbcTemplate = jdbcTemplate;

    }

    public List<Client> getList() {
        return jdbcTemplate.query(GET_ALL_CLIENTS, new BeanPropertyRowMapper<>(Client.class));
    }

    @Override
    public void addNew(Entity entity) {
        Client client = (Client) entity;
        jdbcTemplate.update(ADD_NEW_CLIENT,
                client.getFullName(),
                client.getAddress());
    }

    @Override
    public void update(Entity entity) {
        Client client = (Client) entity;
        jdbcTemplate.update(UPDATE_CLIENT_BY_ID,
                client.getFullName(),
                client.getAddress(),
                client.getID());
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update(DELETE_CLIENT_BY_ID, id);
    }

    @Override
    public Entity show(int id) {
        return jdbcTemplate.queryForObject(GET_CLIENT_BY_ID, new BeanPropertyRowMapper<>(Client.class), id);
    }

}
