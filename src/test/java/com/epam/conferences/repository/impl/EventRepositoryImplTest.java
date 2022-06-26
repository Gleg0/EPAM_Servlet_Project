package com.epam.conferences.repository.impl;

import com.epam.conferences.MainServlet;
import com.epam.conferences.entity.event.Event;
import org.fed333.servletboot.context.ApplicationContext;
import org.fed333.servletboot.testing.TestApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Optional;

class EventRepositoryImplTest {
    private EventRepositoryImpl eventRepository;
    @BeforeEach
    void setUp(){
        ApplicationContext context = TestApplication.run(EventRepositoryImplTest.class, MainServlet.class.getPackageName(),new HashMap<>());
        eventRepository = context.getObject(EventRepositoryImpl.class);
    }
    @Test
    void findById() {
        Optional<Event> actual = eventRepository.findById(10L);
        Assertions.assertTrue(actual.isPresent());
    }

    @Test
    void findAll() {
    }

    @Test
    void findAllByDateAfter() {
    }

    @Test
    void insert() {
    }

    @Test
    void update() {
    }
}