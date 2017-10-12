package com.expertzlab.surveyvi.fileutil;


import com.expertzlab.surveyvi.model.Options;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by preethup on 23/8/17.
 */
public class OptionDataWriter extends Thread {
    Connection con;
    List<Object> list;


    public OptionDataWriter(Connection con, List<Object> list)
    {
        this.con = con;
        this.list = list;

    }
    public void run()
    {

        try {
            OptionRandomizer or = new OptionRandomizer(con);
            list = or.getRandomizedList(list);

            for(Object op :list) {
                System.out.println("In option thread");
                PreparedStatement statement = con.prepareStatement("insert into options values(?,?,?) ");
                statement.setLong(1,((Options)op).getId());
                statement.setLong(2,((Options)op).getQuestionId());
                statement.setInt(3,((Options)op).getWeight());
                statement.execute();
                statement.close();
                System.out.println(" Option Executed successfully");
            }
        } catch (SQLException e) {
            new RuntimeException("Options Write",e);        }
    }
}
