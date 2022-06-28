package com.epam.conferences.entity.dto;

import org.fed333.servletboot.annotation.DTO;

/**
 * Data Transfer Object to assemble User's authorized data.<br>
 * Consists of login and password.<br>
 * @author Roman Kovalchuk
 * @version 1.0
 * */
@DTO
public class AuthorizedDataDto {
    /**
     * User's login.<br>
     * @since 1.0
     * */
    private String username;
    /**
     * User's password.<br>
     * Not hash, the dto transfers the input password from web form.<br>
     * @since 1.0
     * */
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
