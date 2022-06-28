package com.epam.conferences.repository;

import com.epam.conferences.entity.user.Role;
import com.epam.conferences.entity.user.User;

import java.util.List;

public interface UserRepository {
    User findByUsername(String username);
    User findByEmail(String email);
    List<User> findByRole(Role role);
    User getById(Long speakerId);
}
