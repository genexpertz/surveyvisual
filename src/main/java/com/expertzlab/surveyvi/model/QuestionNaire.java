package com.expertzlab.surveyvi.model;

public class QuestionNaire {

    Long id;
    Question[] questions;
    Long programId;

    public Long getId() {  return id; }

    public void setId(Long id) { this.id = id; }
    public Question[] getQuestions() {
        return questions;
    }

    public void setQuestions(Question[] questions) {
        this.questions = questions;
    }

    public Long getProgramId() {
        return programId;
    }

    public void setProgramId(long programId) {
        this.programId = programId;
    }

    public QuestionNaire split(String op) {

        QuestionNaire qus = new QuestionNaire();
        String[] hArray = op.split("-");
        qus.setId((long) Integer.parseInt(hArray[0]));
        return qus;
    }
}
