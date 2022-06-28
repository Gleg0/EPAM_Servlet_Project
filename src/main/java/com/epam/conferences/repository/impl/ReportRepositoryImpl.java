package com.epam.conferences.repository.impl;

import com.epam.conferences.entity.event.Report;
import com.epam.conferences.repository.ReportRepository;
import org.fed333.servletboot.annotation.Singleton;

import java.util.List;
import java.util.Optional;
@Singleton
public class ReportRepositoryImpl implements ReportRepository {
    @Override
    public Report getById(Long id) {
        return null;//TODO implement
    }

    @Override
    public Report insert(Report o) {
        return null;
    }

    @Override
    public Report update(Report o) {
        return null;
    }

    @Override
    public Optional<Report> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<Report> findAll() {
        return null;
    }
}
