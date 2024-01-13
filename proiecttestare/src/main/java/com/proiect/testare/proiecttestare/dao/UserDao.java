package com.proiect.testare.proiecttestare.dao;

import com.proiect.testare.proiecttestare.model.UserModel;
import org.springframework.jdbc.core.JdbcTemplate;

public interface UserDao {

    UserModel getUserById(JdbcTemplate jdbcTemplate, Integer code);

    boolean insertUser(JdbcTemplate jdbcTemplate, String firstName, String lastName, String email);

}
