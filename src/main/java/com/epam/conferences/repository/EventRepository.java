package com.epam.conferences.repository;


import com.epam.conferences.entity.event.Event;
import java.util.Date;
import java.util.List;

public interface EventRepository {
    List<Event> findAll();
    List<Event> findAllByDateAfter(Date date);
}
