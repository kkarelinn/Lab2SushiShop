package com.example.lab2sushishop.model.repositories;

import com.example.lab2sushishop.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Component
@Repository
public class RepositUser implements Repositor {

    private final static String DEFAULT_ROLE = UserAccess.CUSTOMER.toString();
    private final static String GET_ALL_USERS = "select * from users";
    private final static String GET_USER_BY_ID = "select * from users where id=?";
    private final static String DELETE_USER_BY_ID = "delete from users where id=?";
    private final static String UPDATE_USER_BY_ID = "update users set fullname=?, manager=?, access_role=? where id=?";
    private final static String ADD_NEW_USER = "insert into users (fullname, manager, access_role) values (?, ?, ?)";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public RepositUser(JdbcTemplate jdbcTemplate) {
               this.jdbcTemplate = jdbcTemplate;
         }

    @Override
    public List<User> getList() {
        return jdbcTemplate.query(GET_ALL_USERS, new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public void addNew(Entity entity) {
        User user = (User) entity;
//        if (user.getAccessRole().isEmpty()) user.setAccessRole("DEFAULT");
        jdbcTemplate.update(ADD_NEW_USER,
                user.getFullName(),
                user.getManager(),
                user.getAccessRole());
    }

    @Override
    public void update(Entity entity) {
        User user = (User) entity;
        if (user.getAccessRole().isEmpty()) user.setAccessRole(DEFAULT_ROLE);
        jdbcTemplate.update(UPDATE_USER_BY_ID,
                user.getFullName(),
                user.getManager(),
                user.getAccessRole(),
                user.getID());
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update(DELETE_USER_BY_ID, id);
    }

    @Override
    public Entity show(int id) {
      return jdbcTemplate.queryForObject(GET_USER_BY_ID, new BeanPropertyRowMapper<>(User.class), id);
    }

    // get multi List<String[]> from different tables

    public List<String[]> getUsersManString() {
        List<String[]> getUsersManString = new ArrayList<>();
        List<User> userList = getList();
        for (User user : userList) {
            getUsersManString.add(getUserManString(user.getID()));
        }
        return getUsersManString;
    }

    public String[] getUserManString(int usID) {
       User user = (User)show(usID);

        StringBuilder line = new StringBuilder();
        line.append(user.getID()).append("~");              //[0] - ID
        line.append(user.getFullName()).append("~");        //[1] - fullName
        String man = (user.getManager()==0)
                ? "none"
                : ((User)show(user.getManager())).getFullName() ;
        line.append(man).append("~");                       //[2] - manager-name
        line.append(user.getAccessRole());                  //[3] - role

        return line.toString().split("~");
    }
}
