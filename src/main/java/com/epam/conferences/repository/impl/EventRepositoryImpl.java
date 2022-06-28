package com.epam.conferences.repository.impl;

import com.epam.conferences.entity.event.Event;
import com.epam.conferences.repository.EventRepository;
import com.epam.conferences.repository.conection.ConnectionPool;
import com.epam.conferences.repository.dao.persist.DaoPersist;
import com.epam.conferences.service.ServiceUtils;
import org.fed333.servletboot.annotation.Inject;
import org.fed333.servletboot.annotation.Singleton;

import javax.annotation.PostConstruct;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Singleton
public class EventRepositoryImpl implements EventRepository {
    private static final String SELECT_ALL = "SELECT * FROM t_event";
    private static final String INSERT = "INSERT INTO t_event (date,description,name) VALUES (?,?,?)";
    private static final String UPDATE = "UPDATE t_event SET date=?, description=?, name=?";
    private static final String SELECT_ALL_BY_DATE_AFTER = "SELECT * FROM t_event WHERE date > ?";
    private static final String SELECT_BY_ID = "SELECT * FROM t_event WHERE id = ?";
    private static final String SELECT_ALL_BY_DATE_BEFORE = "SELECT * FROM t_event WHERE date <= ?";
    private EventRepositoryPersist eventRepositoryPersist;

    @Inject
    private ConnectionPool pool;
    @PostConstruct
    private void init(){
        eventRepositoryPersist = new EventRepositoryPersist(pool);
    }

    @Override
    public Optional<Event> findById(Long id) {
        return eventRepositoryPersist.findBy(SELECT_BY_ID,preparedStatement -> preparedStatement.setLong(1,id));
    }

    @Override
    public List<Event> findAll() {
        return eventRepositoryPersist.findAll(SELECT_ALL);
    }
    @Override
    public List<Event> findAllByDateAfter(Date date) {
        return eventRepositoryPersist.findAllBy(SELECT_ALL_BY_DATE_AFTER, preparedStatement -> preparedStatement.setObject(1,ServiceUtils.convertDate(date)));
    }

    @Override
    public List<Event> findAllByDateBefore(Date date) {
        return eventRepositoryPersist.findAllBy(SELECT_ALL_BY_DATE_BEFORE, preparedStatement -> preparedStatement.setObject(1,ServiceUtils.convertDate(date)));
    }

    @Override
    public Event insert(Event event) {
        return eventRepositoryPersist.create(INSERT,event);
    }

    @Override
    public Event update(Event event) {
        return eventRepositoryPersist.update(UPDATE,event);
    }

    private static class EventRepositoryPersist extends DaoPersist<Event,Long> {
        public EventRepositoryPersist(ConnectionPool pool) {
            super(pool);
        }

        @Override
        public Event parseObjectFrom(ResultSet result) throws SQLException {
            Event event = new Event();
            event.setId(result.getLong("id"));
            event.setName(result.getString("name"));
            event.setDescription(result.getString("description"));
            event.setDate(result.getDate("date"));
            return event;
        }

        @Override
        public void transferObjectToInsert(Event o, PreparedStatement statement) throws SQLException {
            statement.setObject(1,o.getDate());
            statement.setString(2,o.getDescription());
            statement.setString(3,o.getName());
        }

        @Override
        public void transferObjectToUpdate(Event o, PreparedStatement statement) throws SQLException {
            statement.setObject(1,o.getDate());
            statement.setString(2,o.getDescription());
            statement.setString(3,o.getName());
        }
    }
}
