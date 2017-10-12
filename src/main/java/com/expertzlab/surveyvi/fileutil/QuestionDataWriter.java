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
    List<Question> list;


    public QuestionDataWriter(Connection con, List<Question> list) {
        this.con = con;
        this.list = list;
    }
    public void run()
    {

        try {
            //QuestionRandomizer qusr = new QuestionRandomizer(con);
            //list = qusr.getRandomizedList(list);
        for(Question qus :list) {
            System.out.println("In new thread");
            PreparedStatement statement = con.prepareStatement("insert into question values(?,?,?,?,?,?) ");
            statement.setInt(1,((Question)qus).getId());
            statement.setString(2,qus.getDescription());
            statement.setString(3,qus.getOption1AsString());
            statement.setString(4,qus.getOption2AsString());
            statement.setString(5,qus.getOption3AsString());
            statement.setString(6,qus.getOption4AsString());
            statement.execute();
            statement.close();
            System.out.println("Question Executed successfully");
        }
        } catch (SQLException e) {
            new RuntimeException("Question Write",e);
        }
    }

}
