package com.proiect.testare.proiecttestare.dao.impl;

import com.proiect.testare.proiecttestare.dao.UserDao;
import com.proiect.testare.proiecttestare.model.UserModel;
import org.springframework.jdbc.core.JdbcTemplate;

public class DefaultUserDao implements UserDao {

    @Override
    public UserModel getUserById(JdbcTemplate jdbcTemplate, Integer code) {
        String query = "SELECT * FROM users WHERE users.code = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{code}, (rs, rowNum) ->
                new UserModel(
                        rs.getInt("code"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("email")
                ));
    }

    @Override
    public boolean insertUser(JdbcTemplate jdbcTemplate, String firstName, String lastName, String email) {
        int update = jdbcTemplate.update("INSERT INTO users(firstName, lastName, email) VALUES (?,?,?)", firstName, lastName, email);
        return update == 1;
    }

}
