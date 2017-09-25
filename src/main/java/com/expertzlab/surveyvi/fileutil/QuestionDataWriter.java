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
            PreparedStatement statement = con.prepareStatement("insert into question values(?,?,?,?,?,?) ");
            statement.setInt(1,((Question)qus).getId());
            statement.setString(2,((Question)qus).getDescription());
            statement.setString(3,((Question)qus).getOption1());
            statement.setString(4,((Question)qus).getOption2());
            statement.setString(5,((Question)qus).getOption3());
            statement.setString(6,((Question)qus).getOption4());
            statement.execute();
            System.out.println("Question Executed successfully");
        }
        } catch (SQLException e) {
            new RuntimeException("Question Write",e);
        }
    }

}
