package com.epam.conferences.entity.dto;

import org.fed333.servletboot.annotation.DTO;

@DTO
public class ReportDto {
    public Long getSpeakerId() {
        return speakerId;
    }

    public void setSpeakerId(Long speakerId) {
        this.speakerId = speakerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAccepted() {
        return accepted;
    }

    public void setAccepted(Boolean accepted) {
        this.accepted = accepted;
    }

    private Long speakerId;
    private String name;
    private String description;
    private Boolean accepted;
}
