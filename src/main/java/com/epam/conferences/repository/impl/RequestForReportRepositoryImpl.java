package com.epam.conferences.repository.impl;

import com.epam.conferences.entity.event.UserRequest;
import com.epam.conferences.repository.RequestForReportRepository;

import java.util.List;
import java.util.Optional;

public class RequestForReportRepositoryImpl implements RequestForReportRepository {
    @Override
    public UserRequest save(UserRequest o) {
        return RequestForReportRepository.super.save(o);
    }

    @Override
    public UserRequest insert(UserRequest o) {
        return null;
    }

    @Override
    public UserRequest update(UserRequest o) {
        return null;
    }

    @Override
    public Optional<UserRequest> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<UserRequest> findAll() {
        return null;
    }

    @Override
    public void delete(UserRequest o) {

    }
}
