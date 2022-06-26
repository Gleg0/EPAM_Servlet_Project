package com.epam.conferences.repository.dao;

import com.epam.conferences.entity.event.Event;
import com.epam.conferences.repository.EventRepository;
import com.epam.conferences.repository.conection.ConnectionPool;
import org.fed333.servletboot.annotation.Inject;
import org.fed333.servletboot.annotation.Singleton;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
@Singleton
public class EventRepositoryImpl implements EventRepository {
    @Inject
    private ConnectionPool pool;
    @Override
    public List<Event> findAll() {
        return null;
    }
    @Override
    public List<Event> findAllByDateAfter(Date date) {
        return null;
    }
}
