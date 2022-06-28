package com.epam.conferences.controller;


import com.epam.conferences.entity.dto.AuthorizedDataDto;
import com.epam.conferences.service.AuthorizationService;
import org.fed333.servletboot.annotation.Controller;
import org.fed333.servletboot.annotation.Inject;
import org.fed333.servletboot.annotation.RequestMapping;
import org.fed333.servletboot.dispatcher.HttpMethod;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Inject
    private AuthorizationService authorizationService;
    @RequestMapping(url = "/login",method = HttpMethod.GET)
    public String mainGet(HttpSession session, AuthorizedDataDto request){
        authorizationService.login(request,session);
        return "login.jsp";
    }
}
