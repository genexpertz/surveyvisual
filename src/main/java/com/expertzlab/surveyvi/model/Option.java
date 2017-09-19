package com.expertzlab.surveyvi.model;

/**
 * Created by preethup on 6/9/17.
 */
public class Option {
    long id;
    long questionId;
    int weight;


    public long getId() { return id; }

    public void setId(long id) {
        this.id = id;
    }

    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }


}
