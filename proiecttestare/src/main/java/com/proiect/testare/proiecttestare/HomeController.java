package com.proiect.testare.proiecttestare;

import com.proiect.testare.proiecttestare.dao.UserDao;
import com.proiect.testare.proiecttestare.form.LoginForm;
import com.proiect.testare.proiecttestare.model.UserModel;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

@Controller()
public class HomeController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Resource(name = "userDao")
    private UserDao userDao;

    @GetMapping("/home")
    public ModelAndView home() {
        UserModel loggedInUser = userDao.getLoggedInUser(jdbcTemplate);
        if (Objects.nonNull(loggedInUser)) {
            ModelAndView modelAndView = new ModelAndView("/home?lang=" + loggedInUser.getCurrentLang());
            modelAndView.addObject("currentCustomer", loggedInUser);
            modelAndView.setViewName("home");

            return modelAndView;
        }

        ModelAndView modelAndView = new ModelAndView("/home?lang=en");
        modelAndView.setViewName("home");

        return modelAndView;
    }

    @GetMapping("/home/login")
    public ModelAndView login(LoginForm loginForm) {
        userDao.loginUser(jdbcTemplate, loginForm);

        return new ModelAndView("redirect:" + "/home");
    }

    @GetMapping("/home/logout")
    public ModelAndView login() {
        UserModel loggedInUser = userDao.getLoggedInUser(jdbcTemplate);
        userDao.logoutUser(jdbcTemplate, loggedInUser);

        return new ModelAndView("redirect:" + "/home");
    }

}
