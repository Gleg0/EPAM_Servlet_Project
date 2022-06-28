package com.epam.conferences.service;

import com.epam.conferences.entity.dto.UserDto;
import com.epam.conferences.entity.user.Role;
import com.epam.conferences.entity.user.User;
import com.epam.conferences.repository.UserRepository;
import org.fed333.servletboot.annotation.Inject;
import org.fed333.servletboot.annotation.Singleton;
import org.fed333.servletboot.security.encoding.password.PasswordEncoder;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Singleton
public class UserService {
    @Inject
    private UserRepository userRepository;
    @Inject
    private PasswordEncoder passwordEncoder;

    public User registerNewUserAccount(UserDto userDto){
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setEmail(userDto.getEmail());
        user.setRole(userDto.getRole());
        return userRepository.save(user);
    }

    public User findUserById(Long userId) {
        Optional<User> userFromDb = userRepository.findById(userId);
        return userFromDb.orElse(new User());
    }

    public List<User> allUsers() {
        return userRepository.findAll();
    }

    public boolean deleteUser(Long userId) {
        if (userRepository.findById(userId).isPresent()) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }

    public boolean emailExists(String email) {
        return userRepository.findByEmail(email) != null;
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> allSpeakers() {
        return userRepository.findByRole(Role.SPEAKER);
    }

    public User findUserByName(String username) {
        return userRepository.findByUsername(username);
    }

}
