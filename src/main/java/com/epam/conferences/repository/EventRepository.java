package com.epam.conferences.repository;


import com.epam.conferences.entity.event.Event;
import com.epam.conferences.repository.dao.ReadWriteDao;

import java.util.Date;
import java.util.List;

public interface EventRepository extends ReadWriteDao<Event,Long> {
    List<Event> findAllByDateAfter(Date date);

    List<Event> findAllByDateBefore(Date from);
}
