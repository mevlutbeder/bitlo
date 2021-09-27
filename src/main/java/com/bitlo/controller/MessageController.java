package com.bitlo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MessageController {

    @GetMapping("/welcome")
    public String getMessage(Model model) {
        System.out.println(model);

        return "welcome";
    }

}