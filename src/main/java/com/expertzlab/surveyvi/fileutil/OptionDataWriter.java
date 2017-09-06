package com.expertzlab.surveyvi.fileutil;


import com.expertzlab.surveyvi.model.Option;

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
                System.out.println("In new thread");
                PreparedStatement statement = con.prepareStatement("insert into option values(?,?,?) ");
                statement.setLong(1,((Option)op).getId());
                statement.setLong(2,((Option)op).getQuestionId());
                statement.setLong(3,((Option)op).getWeightage());
                statement.execute();
                System.out.println("Executed successfully");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
