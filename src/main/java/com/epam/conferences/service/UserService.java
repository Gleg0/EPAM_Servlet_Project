package com.epam.conferences.service;

import com.epam.conferences.repository.UserRepository;
import org.fed333.servletboot.annotation.Inject;
import org.fed333.servletboot.annotation.Singleton;

@Singleton
public class UserService {
    @Inject
    UserRepository userRepository;
}
