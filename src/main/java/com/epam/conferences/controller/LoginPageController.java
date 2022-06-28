package com.epam.conferences.controller;


import org.fed333.servletboot.annotation.Controller;
import org.fed333.servletboot.annotation.RequestMapping;
import org.fed333.servletboot.dispatcher.HttpMethod;

@Controller
public class LoginPageController {
    @RequestMapping(url = "/login",method = HttpMethod.GET)
    public String mainGet(){
        return "login.jsp";
    }
}
