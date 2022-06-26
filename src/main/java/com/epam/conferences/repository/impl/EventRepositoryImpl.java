package com.epam.conferences.repository.impl;

import com.epam.conferences.entity.event.Event;
import com.epam.conferences.repository.EventRepository;
import com.epam.conferences.repository.conection.ConnectionPool;
import com.epam.conferences.repository.dao.persist.DaoPersist;
import org.fed333.servletboot.annotation.Inject;
import org.fed333.servletboot.annotation.Singleton;

import javax.annotation.PostConstruct;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Singleton
public class EventRepositoryImpl implements EventRepository {
    private static final String SELECT_ALL = "SELECT * FROM t_event";
    private static final String INSERT = "INSERT INTO t_event (date,description,name) VALUES (?,?,?)";
    private static final String UPDATE = "UPDATE t_event SET date=?, description=?, name=?";
    private static final String SELECT_ALL_BY_DATE_AFTER = "SELECT * FROM t_event WHERE date > ?";

    private EventRepositoryPersist eventRepositoryPersist;

    @Inject
    private ConnectionPool pool;
    @PostConstruct
    private void init(){
        eventRepositoryPersist = new EventRepositoryPersist(pool);
    }

    @Override
    public Optional<Event> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<Event> findAll() {
        return eventRepositoryPersist.findAll(SELECT_ALL);
    }
    @Override
    public List<Event> findAllByDateAfter(Date date) {
        return eventRepositoryPersist.findAllBy(SELECT_ALL_BY_DATE_AFTER, preparedStatement -> preparedStatement.setObject(1,date));
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
