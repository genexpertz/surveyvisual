package com.expertzlab.surveyvi.model;

/**
 * Created by preethup on 14/9/17.
 */
public class Attendance {
    long id;
    int projectId;
    int participantId;
    int eventId;
    String attendance;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getParticipantId() {
        return participantId;
    }

    public void setParticipantId(int participantId) {
        this.participantId = participantId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }


}
