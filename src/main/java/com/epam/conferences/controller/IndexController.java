package com.epam.conferences.controller;

import org.fed333.servletboot.annotation.Controller;
import org.fed333.servletboot.annotation.RequestMapping;
import org.fed333.servletboot.dispatcher.HttpMethod;
import org.fed333.servletboot.web.Model;

@Controller
public class IndexController {

    @RequestMapping(url = "/", method = HttpMethod.GET)
    public String getIndex(Model model){
        model.addAttribute("number",1);
        return "index.jsp";
    }

}
