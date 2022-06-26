package com.epam.conferences.listener;

import org.fed333.servletboot.Application;
import org.fed333.servletboot.context.ApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.HashMap;
import java.util.Map;

@WebListener
public class ContextListener implements ServletContextListener {

    public static final String APPLICATION_CONTEXT_ATTRIBUTE = "applicationContext";

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        ApplicationContext applicationContext = Application.run("com.epam.conferences", new HashMap<>(Map.of()));
        servletContext.setAttribute(APPLICATION_CONTEXT_ATTRIBUTE, applicationContext);
    }
}