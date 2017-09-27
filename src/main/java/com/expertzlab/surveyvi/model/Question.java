package com.expertzlab.surveyvi.model;

import javax.swing.text.html.Option;

public class Question {
    int id;
    String description;
    Options option1;
    Options option2;
    Options option3;
    Options option4;
    String record = null;
    private long questionId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId(String id) {
        this.id = Integer.parseInt(id);
    }


    public Options getOption1() {
        return option1;
    }

    public String getOption1AsString() {
        if(option1 == null) return null;
        return option1.toString();
    }


    public void setOption1(Options option) {
        this.option1 = option;
    }

    public void setOption1(String option) {
        this.option1 = split(option);
    }

    public Options getOption2() {
        return option2;
    }

    public String getOption2AsString() {
        if(option2 == null) return null;
        return option2.toString();
    }

    public void setOption2(Options option) {
        this.option2 = option;
    }

    public void setOption2(String option) {
        this.option2 = split(option);
    }

    public Options getOption3() {
        return option3;
    }

    public String getOption3AsString() {

        if(option3 == null) return null;
        return option3.toString();
    }

    public void setOption3(Options option) {
        this.option3 = option;
    }

    public void setOption3(String option) {
        this.option3 = split(option);
    }

    public Options getOption4() {
        return option4;
    }

    public String getOption4AsString() {

        if(option4 == null) return null;
        return option4.toString();
    }

    public void setOption4(Options option) {

        this.option4 = option;
    }

    public void setOption4(String option) {
        this.option4 = split(option);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Options split(String op) {

        Options option = new Options();
        String[] rArray = op.split(",");
        option.setQuestionId(id);
        String[] ids = rArray[0].split(":");
        option.setId(Integer.parseInt(ids[0]));
        option.setWeight(Integer.parseInt(rArray[1]));
        return option;
    }

    public long getQuestionId() {
        return questionId;
    }
}
