package com.proiect.testare.proiecttestare;

import com.proiect.testare.proiecttestare.model.UserModel;
import com.proiect.testare.proiecttestare.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @Resource(name = "userService")
    private UserService userService;

    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");

        UserModel madalinGavrila = userService.getUserByCode("MadalinGavrila");

        modelAndView.addObject("user", madalinGavrila);
        modelAndView.addObject("test", "pula");

        return modelAndView;
    }

}
