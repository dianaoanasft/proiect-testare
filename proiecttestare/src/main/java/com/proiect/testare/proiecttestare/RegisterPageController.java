package com.proiect.testare.proiecttestare;

import com.proiect.testare.proiecttestare.dao.UserDao;
import com.proiect.testare.proiecttestare.form.RegisterForm;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterPageController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Resource(name = "userDao")
    private UserDao userDao;

    @GetMapping("/register")
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView("/register?lang=en");
        modelAndView.setViewName("register");

        return modelAndView;
    }

    @GetMapping("/registerCustomer")
    public ModelAndView register(RegisterForm registerForm) {
        boolean registered = userDao.registerUser(jdbcTemplate, registerForm);

        if (registered) {
            return new ModelAndView("redirect:" + "/home");
        }

        ModelAndView modelAndView = new ModelAndView("/register?lang=en");
        modelAndView.setViewName("register");

        return modelAndView;
    }

}
