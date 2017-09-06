package com.expertzlab.surveyvi.model;

public class TargetClass
{
    long id;
    long refAnsId;

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    float percentage;

    public long getRefAnsId() {
        return refAnsId;
    }

    public void setRefAnsId(long refAnsId) {
        this.refAnsId = refAnsId;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }
}
