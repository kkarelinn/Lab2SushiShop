package com.example.lab2sushishop.model.repositories;

import com.example.lab2sushishop.model.Category;
import com.example.lab2sushishop.model.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Repository
public class RepositCategory implements Repositor {
    private final static String GET_ALL_CATEGORIES = "select * from category order by id";
    private final static String GET_CATEGORY_BY_ID = "select * from category where id=?";
    private final static String DELETE_CATEGORY_BY_ID = "delete from category where id=?";
    private final static String UPDATE_CATEGORY_BY_ID = "update category set title=?, description=?, date=?  where id=?";
    private final static String ADD_NEW_CATEGORY = "insert into category (title, description, date) values (?, ?, ?)";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public RepositCategory(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<?> getList() {
        return jdbcTemplate.query(GET_ALL_CATEGORIES, new BeanPropertyRowMapper<>(Category.class));
    }

    @Override
    public void addNew(Entity entity) {
        Category category = (Category) entity;
        if (category.getDate() == null) category.setDate(getNowDate());
        jdbcTemplate.update(ADD_NEW_CATEGORY,
                category.getTitle(),
                category.getDescription(),
                category.getDate());
    }

    @Override
    public Entity show(int id) {
        return jdbcTemplate.queryForObject(GET_CATEGORY_BY_ID, new BeanPropertyRowMapper<>(Category.class), id);
    }

    @Override
    public void update(Entity entity) {
        Category category = (Category) entity;
        category.setDate(getNowDate());
        jdbcTemplate.update(UPDATE_CATEGORY_BY_ID,
                category.getTitle(),
                category.getDescription(),
                category.getDate(),
                category.getID());
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update(DELETE_CATEGORY_BY_ID, id);
    }


}
