package com.epam.conferences.service;

import com.epam.conferences.MainServlet;
import com.epam.conferences.entity.event.Report;
import com.epam.conferences.repository.ReportRepository;
import org.fed333.servletboot.context.ApplicationContext;
import org.fed333.servletboot.testing.TestApplication;
import org.fed333.servletboot.testing.annotation.MockBean;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashMap;

class ReportServiceTest {
    private ReportService reportService;
    @MockBean
    private ReportRepository reportRepository;
    @BeforeEach
    private void setUp(){
        ApplicationContext context = TestApplication.run(ReportServiceTest.class, MainServlet.class.getPackageName(),new HashMap<>());
        reportService = context.getObject(ReportService.class);
        reportRepository = context.getObject(ReportRepository.class);
    }
    @Test
    void getReportById() {
        Report expected = new Report();
        Long id = 1L;
        Report actual = reportService.getReportById(id);
        Mockito.verify(reportRepository).getById(id);
    }
}