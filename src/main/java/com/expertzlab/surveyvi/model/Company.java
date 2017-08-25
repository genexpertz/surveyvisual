package com.expertzlab.surveyvi.model;

public class Company
{
    long Id;
    String name;
    String address;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}