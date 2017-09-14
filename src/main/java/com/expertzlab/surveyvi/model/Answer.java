package com.expertzlab.surveyvi.model;

public class Answer
{
    long id;
    long participantId;
    long questionId;
    long optionId;

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
}