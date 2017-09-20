package com.expertzlab.surveyvi.model;

import java.util.Date;

public class Event
{
    public long id;
    String eventName;
    String place;
    String date;
    String projectId;
    String agentId;
    private int eventId;

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProjectId() {
        return String.valueOf(projectId);
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getAgentId() {
        return String.valueOf(agentId);
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public int getEventId() {
        return eventId;
    }
}
