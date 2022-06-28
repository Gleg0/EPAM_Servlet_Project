package com.epam.conferences.repository;

import com.epam.conferences.entity.Entity;
import com.epam.conferences.entity.event.Report;
import com.epam.conferences.entity.event.UserRequest;
import com.epam.conferences.repository.dao.Dao;
import com.epam.conferences.repository.dao.ReadWriteDao;

public interface RequestForReportRepository extends Dao<UserRequest,Long> {
}
