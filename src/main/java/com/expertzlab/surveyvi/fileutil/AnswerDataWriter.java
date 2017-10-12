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


    public AnswerDataWriter(Connection con) {
        this.con = con;
    }

    public void execute(Answer answer) {

        try {
                System.out.println("In Answer thread");
                PreparedStatement statement = con.prepareStatement("insert into answer values(?,?,?,?,?,?) ");
                statement.setLong(1, answer.getId());
                statement.setLong(2, answer.getParticipantId());
                statement.setLong(3, answer.getQuestionId());
                statement.setLong(4, answer.getOptionId());
                statement.setLong(5, answer.getEventId());
                statement.setLong(6, answer.getProgarmId());
                statement.execute();
                statement.close();
                System.out.println("Answer Executed successfully");

        } catch (SQLException e) {
            new RuntimeException("Answer Write failed", e);
        }
    }

}
