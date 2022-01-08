package com.example.lab2sushishop.model.repositories;

import com.example.lab2sushishop.model.Category;
import com.example.lab2sushishop.model.Entity;
import com.example.lab2sushishop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Component
@Repository
public class RepositProduct implements Repositor{

    private final static int DEFAULT_CATEGORY_ID = 1;

    private final static String GET_ALL_PRODUCTS = "select * from products";
    private final static String GET_ALL_CATEGORIES = "select * from category";
    private final static String GET_PRODUCT_BY_ID = "select * from products where id=?";
    private final static String GET_CATEGORY_BY_ID = "select * from category where id=?";
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
    public List<Category> getListCats() {
        return jdbcTemplate.query(GET_ALL_CATEGORIES, new BeanPropertyRowMapper<>(Category.class));
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
    public Category getCatById(int cat_id) {
        return jdbcTemplate.queryForObject(GET_CATEGORY_BY_ID, new BeanPropertyRowMapper<>(Category.class), cat_id);
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




    // get multi List<String[]> from different tables

    public List<String[]> getProdsWithCatString() {
        List<String[]> getProdsWithCatString = new ArrayList<>();
        List<Product> prodList = jdbcTemplate.query(GET_ALL_PRODUCTS, new BeanPropertyRowMapper<>(Product.class));
        for (Product prod : prodList) {
           getProdsWithCatString.add(getProdCatString(prod.getID()));
        }
        return getProdsWithCatString;
    }

    public String[] getProdCatString(int prodID) {
        Product product = jdbcTemplate.queryForObject(GET_PRODUCT_BY_ID, new BeanPropertyRowMapper<>(Product.class), prodID);
        Category category = jdbcTemplate.queryForObject(GET_CATEGORY_BY_ID, new BeanPropertyRowMapper<>(Category.class), product.getCategory_ID());

        StringBuilder line = new StringBuilder();
        line.append(product.getID()).append("~");           //[0] - ID
        line.append(product.getTitle()).append("~");        //[1] - title
        line.append(product.getDescription()).append("~");  //[2] - description
        line.append(product.getDate()).append("~");         //[3] - date
        line.append(category.getTitle()).append("~");       //[4] - title-category
        line.append(product.getPriceUsd()).append("~");     //[5] - price_USD
        String link = (product.getLinkProd_ID()==0)? "none" : show(product.getLinkProd_ID()).getTitle();
        line.append(link);                                  //[6] - link_prod

        return line.toString().split("~");
    }






}
