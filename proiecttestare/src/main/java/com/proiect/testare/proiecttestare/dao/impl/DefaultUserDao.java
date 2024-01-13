package com.proiect.testare.proiecttestare.dao.impl;

import com.proiect.testare.proiecttestare.dao.UserDao;
import com.proiect.testare.proiecttestare.form.LoginForm;
import com.proiect.testare.proiecttestare.form.RegisterForm;
import com.proiect.testare.proiecttestare.model.UserModel;
import com.proiect.testare.proiecttestare.model.mapper.UserModelRowMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class DefaultUserDao implements UserDao {

    @Override
    public UserModel getUserById(JdbcTemplate jdbcTemplate, Integer code) {
        String query = "SELECT * FROM users WHERE users.code = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{code}, new UserModelRowMapper());
    }

    @Override
    public boolean insertUser(JdbcTemplate jdbcTemplate, String firstName, String lastName, String email) {
        int update = jdbcTemplate.update("INSERT INTO users(firstName, lastName, email) VALUES (?,?,?)", firstName, lastName, email);
        return update == 1;
    }

    @Override
    public UserModel getLoggedInUser(JdbcTemplate jdbcTemplate) {
        String query = "SELECT * FROM users WHERE users.loggedIn = ?";
        try {
            return jdbcTemplate.queryForObject(query, new Object[]{1}, new UserModelRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void logoutUser(JdbcTemplate jdbcTemplate, UserModel userModel) {
        jdbcTemplate.update("UPDATE users SET loggedIn = ? WHERE code = ?", new Object[]{0, userModel.getCode()});
    }

    @Override
    public boolean loginUser(JdbcTemplate jdbcTemplate, LoginForm loginForm) {
        try {
            jdbcTemplate.queryForObject("SELECT * FROM users WHERE email = ? AND password = ?", new Object[]{loginForm.getEmail(), loginForm.getPassword()}, new UserModelRowMapper());
            jdbcTemplate.update("UPDATE users SET loggedIn = ? WHERE email = ? AND password = ?", new Object[]{1, loginForm.getEmail(), loginForm.getPassword()});

            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }

    @Override
    public boolean registerUser(JdbcTemplate jdbcTemplate, RegisterForm registerForm) {
        int update = jdbcTemplate.update("INSERT INTO users(firstName, lastName, email, password, currentLang, loggedIn) VALUES (?,?,?,?,?, ?)", registerForm.getFirstName(), registerForm.getLastName(), registerForm.getEmail(), registerForm.getPassword(), "en", 0);
        return update == 1;
    }


}