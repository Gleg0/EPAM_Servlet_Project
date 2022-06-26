package com.epam.conferences.service;

import com.epam.conferences.entity.event.Report;
import com.epam.conferences.repository.ReportRepository;
import org.fed333.servletboot.annotation.Inject;
import org.fed333.servletboot.annotation.Singleton;

@Singleton
public class ReportService {
    @Inject
    private ReportRepository reportRepository;
    public Report getReportById(Long id) {
        return reportRepository.getById(id);
    }
}
