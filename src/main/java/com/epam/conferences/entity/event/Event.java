package com.epam.conferences.entity.event;

import com.epam.conferences.entity.user.User;

import java.util.Date;
import java.util.List;

public class Event {
    private Long id;
    private String name;
    private Date date;
    private String description;
    private List<Report> reports;
    private List<User> users;
    public int getUsersSize(){
        return users.size();
    }
    public int getReportsSize(){
        return reports.size();
    }
}
