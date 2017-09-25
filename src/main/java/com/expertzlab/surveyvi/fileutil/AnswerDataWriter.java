package com.expertzlab.surveyvi.fileutil;

import com.expertzlab.surveyvi.model.Answer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by preethup on 12/8/17.
 */
public class AnswerDataWriter extends Thread {

    Connection con;
    List<Object> list;


    public AnswerDataWriter(Connection con, List<Object> list)
    {
        this.con = con;
        this.list = list;

    }
    public void run()
    {

        try {
            AnswerRandomizer pr = new AnswerRandomizer(con);
            list = pr.getRandomizedList(list);
        for(Object pt :list) {
            System.out.println("In Answer thread");
            PreparedStatement statement = con.prepareStatement("insert into answer values(?,?,?,?) ");
            statement.setLong(1,((Answer)pt).getId());
            statement.setLong(2,((Answer)pt).getParticipantId());
            statement.setLong(3,((Answer)pt).getQuestionId());
            statement.setLong(4,((Answer)pt).getOptionId());
            statement.execute();
            System.out.println("Answer Executed successfully");
        }
        } catch (SQLException e) {
            new RuntimeException("Answer Write",e);
        }
    }

}
