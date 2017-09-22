package com.expertzlab.surveyvi.model;

public class Project
{
    long id;
    String name;
    String progId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public void setId(String id){ if(id != null){ this.id =Long.parseLong(id);}
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProgId() {
        return progId;
    }

    public void setProgId(String progId) {
        this.progId = progId;
    }


}
