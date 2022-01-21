package com.example.lab2sushishop.model.repositories;

import com.example.lab2sushishop.model.Category;
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
public class RepositProduct implements Repositor {

    private final static int DEFAULT_CATEGORY_ID = 1;

    private final static String GET_ALL_PRODUCTS = "select * from products order by id";
    private final static String GET_PRODUCT_BY_ID = "select * from products where id=?";
    private final static String DELETE_PRODUCT_BY_ID = "delete from products where id=?";
    private final static String UPDATE_PRODUCT_BY_ID = "update products set title=?, description=?, date=?, price_usd=?, category_id=?, linkprod_id=? where id=?";
    private final static String ADD_NEW_PRODUCT = "insert into products (title, description, date, price_usd, category_id, linkprod_id) values (?, ?, ?, ?, ?, ?)";

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    private RepositCategory repositCategory;


    @Autowired
    public RepositProduct(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Product> getList() {
        List<Product> list = jdbcTemplate.query(GET_ALL_PRODUCTS, new BeanPropertyRowMapper<>(Product.class));
        list.forEach(p -> {
            p.setLinkProduct(show(p.getLinkprod_id()));
            p.setCategory(getCatById(p.getCategory_id()));
        });
        return list;
    }

    public List<Category> getListCats() {
        return repositCategory.getList();
    }

    @Override
    public void addNew(Entity entity) {
        Product product = (Product) entity;
        if (product.getDate() == null) product.setDate(getNowDate());
        int category_ID = (product.getCategory_id() == 0) ? DEFAULT_CATEGORY_ID : product.getCategory_id();  //change
        jdbcTemplate.update(ADD_NEW_PRODUCT,
                product.getTitle(),
                product.getDescription(),
                product.getDate(),
                product.getPriceUsd(),
                category_ID,                         //change
                product.getLinkprod_id());
    }

    @Override
    public Product show(int id) {
        if (id == 0) return null;
        Product product = jdbcTemplate.queryForObject(GET_PRODUCT_BY_ID, new BeanPropertyRowMapper<>(Product.class), id);
        return product;
    }

    public Category getCatById(int cat_id) {
        return (cat_id == 0) ? null : repositCategory.show(cat_id);
    }

    @Override
    public void update(Entity entity) {
        Product product = (Product) entity;
        product.setDate(getNowDate());
        int category_ID = (product.getCategory_id() == 0) ? DEFAULT_CATEGORY_ID : product.getCategory_id();
        jdbcTemplate.update(UPDATE_PRODUCT_BY_ID,

                product.getTitle(),
                product.getDescription(),
                product.getDate(),
                product.getPriceUsd(),
                category_ID,
                product.getLinkprod_id(),
                product.getID());
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update(DELETE_PRODUCT_BY_ID, id);
    }


}
