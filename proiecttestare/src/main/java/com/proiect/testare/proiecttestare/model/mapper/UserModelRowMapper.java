package com.proiect.testare.proiecttestare.model.mapper;

import com.proiect.testare.proiecttestare.model.UserModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class UserModelRowMapper implements RowMapper<UserModel> {

    @Override
    public UserModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        int code = rs.getInt("code");
        if (Objects.nonNull(code)) {
            UserModel userModel = new UserModel();
            userModel.setCode(rs.getInt("code"));
            userModel.setFirstName(rs.getString("firstName"));
            userModel.setLastName(rs.getString("lastName"));
            userModel.setEmail(rs.getString("email"));
            userModel.setPassword(rs.getString("password"));
            userModel.setCurrentLang(rs.getString("currentLang"));
            userModel.setLoggedIn(rs.getInt("loggedIn") == 1);

            return userModel;
        }
        return null;
    }
}
