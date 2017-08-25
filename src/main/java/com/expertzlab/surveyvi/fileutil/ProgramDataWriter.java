package com.expertzlab.surveyvi.fileutil;

import com.expertzlab.surveyvi.model.Program;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by preethup on 23/8/17.
 */
public class ProgramDataWriter extends Thread {
    Connection con;
    List<Object> list;


    public ProgramDataWriter(Connection con, List<Object> list)
    {
        this.con = con;
        this.list = list;

    }
    public void run()
    {

        try {

            for(Object pgm :list) {
                System.out.println("In new thread");
                PreparedStatement statement = con.prepareStatement("insert into program values(?,?) ");
                statement.setLong(1,((Program)pgm).getId());
                statement.setString(2,((Program)pgm).getName());
                statement.execute();
                System.out.println("Executed successfully");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
