package com.epam.conferences.repository;

import com.epam.conferences.entity.user.Role;
import com.epam.conferences.entity.user.User;
import com.epam.conferences.repository.dao.ReadWriteDao;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends ReadWriteDao<User,Long> {
    User findByUsername(String username);
    User findByEmail(String email);
    List<User> findByRole(Role role);
    User getById(Long speakerId);
    Optional<User> findById(Long userId);
    List<User> findAll();
    User save(User user);
    void deleteById(Long userId);
}
