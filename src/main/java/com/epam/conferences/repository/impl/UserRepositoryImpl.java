package com.epam.conferences.repository.impl;

import com.epam.conferences.entity.user.Role;
import com.epam.conferences.entity.user.User;
import com.epam.conferences.repository.UserRepository;

import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public List<User> findByRole(Role role) {
        return null;
    }

    @Override
    public User getById(Long speakerId) {
        return null;
    }
}
