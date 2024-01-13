package com.proiect.testare.proiecttestare;

import com.proiect.testare.proiecttestare.dao.UserDao;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Resource(name = "userDao")
    private UserDao userDao;

    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");

        return modelAndView;
    }

}
