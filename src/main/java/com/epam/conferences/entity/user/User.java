package com.epam.conferences.entity.user;

import java.util.Objects;
import java.util.Set;

public class User{
    private Long id;
    private String username;
    private String email;
    private String password;
    private Role role;
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
