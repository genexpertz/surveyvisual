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
                statement.setLong(1, ((Answer) answer).getId());
                statement.setLong(2, ((Answer) answer).getParticipantId());
                statement.setLong(3, ((Answer) answer).getQuestionId());
                statement.setLong(4, ((Answer) answer).getOptionId());
                statement.setLong(5, ((Answer) answer).getEventId());
                statement.setLong(6, ((Answer) answer).getProgarmId());
                statement.execute();
                statement.close();
                System.out.println("Answer Executed successfully");

        } catch (SQLException e) {
            new RuntimeException("Answer Write failed", e);
        }
    }

}
