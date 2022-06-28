package com.epam.conferences.entity.user;

import com.epam.conferences.entity.Entity;

import java.util.Objects;
import java.util.Set;

public class User implements Entity<Long> {
    private Long id;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    private String username;
    private String email;
    private String password;
    private Role role;
    @Override
    public int hashCode() {
        return getClass().hashCode();
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
