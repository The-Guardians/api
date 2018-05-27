package com.paigunna.api.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    private String welcome(){
//        return "Welcome to Paigunna API";
        return "index.html";
    }

}
