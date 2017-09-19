package com.expertzlab.surveyvi.fileutil;

import com.expertzlab.surveyvi.model.Event;
import com.expertzlab.surveyvi.model.Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by preethup on 13/9/17.
 */
public class ProjectDataReader {


    Connection con;
    Event eventId;
    List list;

    public ProjectDataReader(Connection con)
    {
        this.con = con;
    }
    public List getAttendedProjectList(Event eventId) throws SQLException {
        List list = new ArrayList();
        PreparedStatement statement = con.prepareStatement("select * from project");
        ResultSet res = statement.executeQuery();
        String[] hArray = prepareProjectHeaderArray();
        String[] rArray = new String[10];
        while (res.next()){

            prepareProjectRecordArray(rArray,res);
            ProjectDataSetter pds = new ProjectDataSetter(Project.class,hArray,rArray);
            Project p = pds.run();
            list.add(p);
        }
        res.close();
        System.out.println("Executed successfully");

        return list;
    }

    private void prepareProjectRecordArray(String[] rArray, ResultSet res) throws SQLException {
        rArray[0] = res.getString("id");
        rArray[1] = res.getString("name");
    }

    private String[] prepareProjectHeaderArray(){
        String[] hArray = new String[2];
        hArray[0]= "id";
        hArray[1]="name";
        return  hArray;
    }

    public List getAllProject(Project id) throws SQLException {
        List<Project> list1 = new ArrayList();
        PreparedStatement statement = con.prepareStatement("select * from project");
        ResultSet res1 = statement.executeQuery();
        //Iterator itr =res1.Iterator();
        Project pr = null;
        while (res1.next()){
            pr= new Project();
            pr.setId(res1.getLong("id"));
            pr.setName(res1.getString("name"));
        }
        System.out.println("Executed successfully");
        return list1;
    }

    public static Iterator iterator() {
        return null;
    }
}

