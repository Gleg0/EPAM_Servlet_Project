package com.epam.conferences.entity.event;

import com.epam.conferences.entity.user.User;

public class UserRequest {
    private Long id;
    private User user;
    private RequestType type;
    private Report report;
}
