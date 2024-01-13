package com.proiect.testare.proiecttestare.service.impl;

import com.proiect.testare.proiecttestare.model.UserModel;
import com.proiect.testare.proiecttestare.service.UserService;

public class DefaultUserService implements UserService {
    @Override
    public UserModel getUserByCode(String code) {
        UserModel userModel = new UserModel();
        userModel.setCode(code);
        userModel.setName("John Doe");
        userModel.setEmail("johnDoe@gmail.com");

        return userModel;
    }
}
