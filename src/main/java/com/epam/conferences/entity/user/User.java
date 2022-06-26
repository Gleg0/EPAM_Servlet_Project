package com.epam.conferences.entity.user;

import com.epam.conferences.entity.Entity;

import java.util.Objects;
import java.util.Set;

public class User implements Entity<Long> {
    private Long id;
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
