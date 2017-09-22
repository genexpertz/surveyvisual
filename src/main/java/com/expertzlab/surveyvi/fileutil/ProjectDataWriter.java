package com.expertzlab.surveyvi.fileutil;

import com.expertzlab.surveyvi.model.Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by preethup on 23/8/17.
 */
public class ProjectDataWriter extends Thread{

    Connection con;
    List<Object> list;


    public ProjectDataWriter(Connection con, List<Object> list)
    {
        this.con = con;
        this.list = list;

    }
    public void run()
    {

        try {
            ProjectRandomizer pr1 = new ProjectRandomizer(con);
            list = pr1.getRandomizedList(list);
            for(Object pro :list) {
                System.out.println("In new thread");
                PreparedStatement statement = con.prepareStatement("insert into project values(?,?) ");
                statement.setLong(1,((Project)pro).getId());
                statement.setString(2,((Project)pro).getName());
                statement.setString(3,((Project)pro).getProgId());
                statement.execute();
                System.out.println("Project Executed successfully");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
