package com.epam.conferences.repository;

import com.epam.conferences.entity.event.Report;

public interface ReportRepository {
    Report getById(Long id);
}
