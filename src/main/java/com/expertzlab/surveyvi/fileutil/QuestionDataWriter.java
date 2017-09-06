package com.expertzlab.surveyvi.fileutil;

import com.expertzlab.surveyvi.model.Question;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by preethup on 12/8/17.
 */
public class QuestionDataWriter extends Thread {

    Connection con;
    List<Object> list;


    public QuestionDataWriter(Connection con, List<Object> list)
    {
        this.con = con;
        this.list = list;

    }
    public void run()
    {

        try {
            QuestionRandomizer qusr = new QuestionRandomizer(con);
            list = qusr.getRandomizedList(list);
        for(Object qus :list) {
            System.out.println("In new thread");
            PreparedStatement statement = con.prepareStatement("insert into question values(?,?) ");
            statement.setLong(1,((Question)qus).getId());
            statement.setString(2,((Question)qus).getDescription());
            statement.execute();
            System.out.println("Executed successfully");
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
