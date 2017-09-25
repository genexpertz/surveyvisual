package com.expertzlab.surveyvi.model;

public class Answer
{
    long id;
    long participantId;
    long questionId;
    long optionId;
    long eventId;
    long progarmId;

    public long getParticipantId() {
        return participantId;
    }

    public void setParticipantId(long participantId) {
        this.participantId = participantId;
    }

    public void setParticipantId(String participantId) {
        this.participantId =Integer.parseInt(participantId) ;
    }

    public long getOptionId() { return optionId; }

    public void setOptionId(long optionId) { this.optionId = optionId; }

    public void setOptionId(String optionId) { this.optionId =Integer.parseInt(optionId) ; }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = Integer.parseInt(questionId);
    }

    public long getEventId() {
        return eventId;
    }


    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = Integer.parseInt(eventId);
    }


    public long getProgarmId() {
        return progarmId;
    }

    public void setProgarmId(long progarmId) {
        this.progarmId = progarmId;
    }

    public void setProgramId(String programId) {
        this.progarmId = Integer.parseInt(programId);
    }

}
