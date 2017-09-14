package com.expertzlab.surveyvi.model;

public class Event
{
    long id;
    String projectId;
    String agentId;

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
}
