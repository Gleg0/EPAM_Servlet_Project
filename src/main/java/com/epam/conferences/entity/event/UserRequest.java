package com.epam.conferences.entity.event;

import com.epam.conferences.entity.Entity;
import com.epam.conferences.entity.user.User;

public class UserRequest implements Entity<Long> {
    private Long id;
    private User user;
    private RequestType type;
    private Report report;
    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
