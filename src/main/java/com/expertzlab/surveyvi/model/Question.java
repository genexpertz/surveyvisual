package com.expertzlab.surveyvi.model;

public class Question {
    int id;
    String description;
    Option option1;
    Option option2;
    Option option3;
    Option option4;
    String record = null;
    private long questionId;

    public int getId() { return id; }

    public void setId(int id) {
        this.id = id;
    }
    public void setId(String id) {
        this.id = Integer.parseInt( id);
    }


    public String getOption1() {
        return String.valueOf(option1); }

    public void setOption1(String option) {
        this.option1 = split(option);
    }

    public String getOption2() {
        return String.valueOf(option2); }

    public void setOption2(String option) {
        this.option2 = split(option);
    }

    public String getOption3() {
        return String.valueOf(option3); }

    public void setOption3(String option) {
        this.option3 = split(option);
    }

    public String getOption4() {
        return String.valueOf(option4);
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

    public Option split(String op) {

        Option option = new Option();
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
