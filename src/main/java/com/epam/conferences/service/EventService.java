package com.epam.conferences.service;

import com.epam.conferences.entity.dto.EventDto;
import com.epam.conferences.entity.dto.ReportDto;
import com.epam.conferences.entity.event.Event;
import com.epam.conferences.entity.event.Report;
import com.epam.conferences.entity.user.User;
import com.epam.conferences.repository.EventRepository;
import com.epam.conferences.repository.ReportRepository;
import com.epam.conferences.repository.UserRepository;
import org.fed333.servletboot.annotation.Inject;
import org.fed333.servletboot.annotation.Singleton;
import org.fed333.servletboot.web.data.page.Page;
import org.fed333.servletboot.web.data.pageable.Pageable;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

@Singleton
public class EventService {
    @Inject
    EventRepository eventRepository;
    @Inject
    UserRepository userRepository;
    @Inject
    ReportRepository reportRepository;

    DateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd");

    public Page<Event> getListOfEvents(Pageable pageable, String sortType) {
        switch (sortType){
            case "date": return getListOfEventsAfterCurrentSortedByDate(pageable);
            case "dateDes": return getListOfEventsAfterCurrentSortedByDateRevers(pageable);
            case "users": return getListOfEventsAfterCurrentSortedByUsersSize(pageable);
            case "usersDes": return getListOfEventsAfterCurrentSortedByUsersSizeRevers(pageable);
            case "reports": return getListOfEventsAfterCurrentSortedByReportsSize(pageable);
            case "reportsDes": return getListOfEventsAfterCurrentSortedByReportsSizeRevers(pageable);
            case "before": return getListOfEventsBeforeCurrent(pageable);
        }
        return getListOfEventsAfterCurrent(pageable);
    }

    public Page<Event> getListOfEventsAfterCurrent(Pageable pageable){
        return  ServiceUtils.toPage(eventRepository.findAllByDateAfter(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant())),pageable);
    }
    public Page<Event> getListOfEventsAfterCurrentSortedByDate(Pageable pageable){
        List<Event> events = eventRepository.findAllByDateAfter(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .stream().sorted(Comparator.comparing(Event::getDate)).collect(Collectors.toList());
        return ServiceUtils.toPage(events,pageable);
    }
    public Page<Event> getListOfEventsAfterCurrentSortedByDateRevers(Pageable pageable){
        List<Event> events = eventRepository.findAllByDateAfter(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .stream().sorted(Comparator.comparing(Event::getDate).reversed()).collect(Collectors.toList());
        return ServiceUtils.toPage(events,pageable);
    }
    public Page<Event> getListOfEventsAfterCurrentSortedByUsersSize(Pageable pageable){
        List<Event> events = eventRepository.findAllByDateAfter(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .stream().sorted(Comparator.comparing(Event::getUsersSize)).collect(Collectors.toList());
        return ServiceUtils.toPage(events,pageable);
    }
    public Page<Event> getListOfEventsAfterCurrentSortedByUsersSizeRevers(Pageable pageable){
        List<Event> events = eventRepository.findAllByDateAfter(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .stream().sorted(Comparator.comparing(Event::getUsersSize).reversed()).collect(Collectors.toList());
        return ServiceUtils.toPage(events,pageable);
    }
    public Page<Event> getListOfEventsAfterCurrentSortedByReportsSize(Pageable pageable){
        List<Event> events = eventRepository.findAllByDateAfter(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .stream().sorted(Comparator.comparing(Event::getReportsSize)).collect(Collectors.toList());
        return ServiceUtils.toPage(events,pageable);
    }

    public Page<Event> getListOfEventsAfterCurrentSortedByReportsSizeRevers(Pageable pageable){
        List<Event> events = eventRepository.findAllByDateAfter(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .stream().sorted(Comparator.comparing(Event::getReportsSize).reversed()).collect(Collectors.toList());
        return ServiceUtils.toPage(events,pageable);
    }

    public Page<Event> getListOfEventsBeforeCurrent(Pageable pageable){
        return  ServiceUtils.toPage(eventRepository.findAllByDateBefore(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant())),pageable);
    }

    public Event addNewEvent(EventDto eventDto){
        Event event = new Event();
        event.setName(eventDto.getName());
        try {
            System.out.println(eventDto.getDate());
            event.setDate(dateTimeFormat.parse(eventDto.getDate()));
            System.out.println(event.getDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        event.setDescription(eventDto.getDescription());
        return eventRepository.save(event);
    }
    public Event getEventById(Long id){
        return eventRepository.findById(id).get();
    }

    public Event updateEvent(EventDto eventDto,Long id) {
        Event event = eventRepository.findById(id).get();
        event.setName(eventDto.getName());
        try {
            event.setDate(dateTimeFormat.parse(eventDto.getDate()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        event.setDescription(eventDto.getDescription());
        return eventRepository.save(event);
    }

    public Report addNewReport(Long id, ReportDto reportDto) {
        Report report = new Report();
        report.setName(reportDto.getName());
        report.setDescription(reportDto.getDescription());
        report.setAccepted(true);
        if(reportDto.getSpeakerId()!=null){
            report.setSpeaker(userRepository.getById(reportDto.getSpeakerId()));
        }
        reportRepository.save(report);
        eventRepository.findById(id).get().getReports().add(report);
        eventRepository.save(eventRepository.findById(id).get());
        return report;
    }

    public Report updateReport(ReportDto reportDto, Long reportId) {
        Report report = reportRepository.getById(reportId);
        report.setName(reportDto.getName());
        report.setDescription(reportDto.getDescription());
        if(reportDto.getSpeakerId() != null){
            report.setSpeaker(userRepository.getById(reportDto.getSpeakerId()));
        }
        else {
            report.setSpeaker(null);
        }
        return reportRepository.save(report);
    }

    public Event regForEvent(Long eventId, User userByName) {
        Event event = eventRepository.findById(eventId).get();
        event.getUsers().add(userByName);
        return eventRepository.save(event);
    }

    public Page<Event> getListOfEventsForSpeaker(Pageable pageable,User user) {
        List<Event> events = eventRepository.findAll();
        Map<Long,List<Report>> map = events.stream().collect(Collectors.toMap(Event::getId,Event::getReports));
        List<Event> result = new ArrayList<>();
        for (Map.Entry<Long,List<Report>> entry : map.entrySet()){
            if(entry.getValue().stream().map(Report::getSpeaker).collect(Collectors.toList()).contains(user)){
                result.add(eventRepository.findById(entry.getKey()).get());
            }
        }
        return ServiceUtils.toPage(result,pageable);
    }

    public Report addNewReportRequest(Long eventId, ReportDto reportDto) {
        Report report = new Report();
        report.setName(reportDto.getName());
        report.setDescription(reportDto.getDescription());
        report.setAccepted(false);
        if(reportDto.getSpeakerId()!=null){
            report.setSpeaker(userRepository.getById(reportDto.getSpeakerId()));
        }
        reportRepository.save(report);
        eventRepository.findById(eventId).get().getReports().add(report);
        eventRepository.save(eventRepository.findById(eventId).get());
        return report;
    }

}
