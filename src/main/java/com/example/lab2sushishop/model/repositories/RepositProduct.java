package com.example.lab2sushishop.model.repositories;

import com.example.lab2sushishop.model.Entity;
import com.example.lab2sushishop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Repository
public class RepositProduct implements Repositor{

    private final static int DEFAULT_CATEGORY_ID = 1;

    private final static String GET_ALL_PRODUCTS = "select * from products";
    private final static String GET_PRODUCT_BY_ID = "select * from products where id=?";
    private final static String DELETE_PRODUCT_BY_ID = "delete from products where id=?";
    private final static String UPDATE_PRODUCT_BY_ID = "update products set title=?, description=?, date=?, price_usd=?, category_id=?, linkprod_id=? where id=?";
    private final static String ADD_NEW_PRODUCT = "insert into products (title, description, date, price_usd, category_id, linkprod_id) values (?, ?, ?, ?, ?, ?)";

    private final JdbcTemplate jdbcTemplate;


  @Autowired
    public RepositProduct(JdbcTemplate jdbcTemplate) {
              this.jdbcTemplate = jdbcTemplate;
        }

    @Override
    public List<Product> getList() {
      return jdbcTemplate.query(GET_ALL_PRODUCTS, new BeanPropertyRowMapper<>(Product.class));
    }

    @Override
    public void addNew(Entity entity) {
        Product product = (Product) entity;
        if (product.getDate() == null) product.setDate(getNowDate());
        if (product.getCategory_ID() == 0) product.setCategory_ID(1);
        jdbcTemplate.update(ADD_NEW_PRODUCT,
                product.getTitle(),
                product.getDescription(),
                product.getDate(),
                product.getPriceUsd(),
                product.getCategory_ID(),
                product.getLinkProd_ID());
    }

    @Override
    public Product show(int id) {
      return jdbcTemplate.queryForObject(GET_PRODUCT_BY_ID, new BeanPropertyRowMapper<>(Product.class), id);
    }

    @Override
    public void update(Entity entity) {
      Product product = (Product) entity;
        product.setDate(getNowDate());
        if(product.getCategory_ID()==0) product.setCategory_ID(DEFAULT_CATEGORY_ID);
        jdbcTemplate.update(UPDATE_PRODUCT_BY_ID,
                product.getTitle(),
                product.getDescription(),
                product.getDate(),
                product.getPriceUsd(),
                product.getCategory_ID(),
                product.getLinkProd_ID(),
                product.getID());
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update(DELETE_PRODUCT_BY_ID, id);

    }


}
