package com.epam.conferences.entity.dto;

import com.epam.conferences.entity.user.Role;
import org.fed333.servletboot.annotation.DTO;

@DTO
public class UserDto {
    private String username;
    private String email;
    private Role role;
    private String password;
    private String confirmPassword;
}
