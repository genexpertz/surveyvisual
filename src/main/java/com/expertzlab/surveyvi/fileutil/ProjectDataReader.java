package com.expertzlab.surveyvi.fileutil;

import com.expertzlab.surveyvi.model.Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by preethup on 19/9/17.
 */
public class ProjectDataReader {

    Connection con;
    ResultSet res;
    PreparedStatement statement;
    long progId;

    public boolean hasNext() {

        try {
            return res.next();
        } catch (SQLException e) {
            return false;
        }
    }

    public ProjectDataReader(Connection con, long id) {

        this.con = con;
        progId = id;
    }
    public void getProjectList() throws SQLException {
        statement = con.prepareStatement("select * from project");
        res = statement.executeQuery();
    }

    public void getProjectListFromProgram() throws SQLException {
        statement = con.prepareStatement("select * from project where progId=?");
        statement.setLong(1,progId);
        res = statement.executeQuery();
    }

    public void close() throws SQLException{
        res.close();
        statement.close();
        System.out.println("Executed successfully");
    }

    public Project get() throws SQLException {
        String[] hArray = prepareProjectHeaderArray();
        String[] rArray = new String[3];

        prepareProjectArray(rArray,res);
        ProjectDataSetter prds = new ProjectDataSetter(Project.class,hArray,rArray);
        Project p = prds.run();
        return p;
    }

    private void prepareProjectArray(String[] rArray, ResultSet res) throws SQLException {
        rArray[0] = String.valueOf(res.getInt(1));
        rArray[1] = res.getString(2);
        rArray[2] = String.valueOf(res.getInt(3));
    }

    private String[] prepareProjectHeaderArray(){
        String[] hArray = new String[3];
        hArray[0]= "id";
        hArray[1]="name";
        hArray[2]="progId";
        return  hArray;
    }

    /*
    public List getAllProject() throws SQLException {
        List<Project> list1 = new ArrayList();
        PreparedStatement statement = con.prepareStatement("select * from project");
        ResultSet res1 = statement.executeQuery();
        //Iterator itr =res1.Iterator();
        Project pt = null;
        while (res1.next()){
            pt = new Project();
            pt.setId(res1.getLong("id"));
            pt.setName(res1.getString("name"));
            pt.setProgId(res1.getString("progId"));
            list1.add(pt);
        }
        System.out.println("Executed successfully");
        return list1;
    }
    */

    public static Iterator iterator() {
        return null;
    }
}
