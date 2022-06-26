package com.epam.conferences.entity.event;

import com.epam.conferences.entity.Entity;
import com.epam.conferences.entity.user.User;

import java.util.Date;
import java.util.List;

public class Event implements Entity<Long> {

    private Long id;
    private String name;
    private Date date;
    private String description;
    private List<Report> reports;
    private List<User> users;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public int getUsersSize(){
        return users.size();
    }
    public int getReportsSize(){
        return reports.size();
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
