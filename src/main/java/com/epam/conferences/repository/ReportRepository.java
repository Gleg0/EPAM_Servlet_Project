package com.epam.conferences.repository;

import com.epam.conferences.entity.event.Report;
import com.epam.conferences.repository.dao.Insertable;
import com.epam.conferences.repository.dao.ReadWriteDao;
import com.epam.conferences.repository.dao.Readable;

public interface ReportRepository extends ReadWriteDao<Report,Long> {
    Report getById(Long id);
}
