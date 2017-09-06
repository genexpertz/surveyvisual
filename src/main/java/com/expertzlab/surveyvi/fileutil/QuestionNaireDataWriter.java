package com.expertzlab.surveyvi.fileutil;

import com.expertzlab.surveyvi.model.QuestionNaire;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by preethup on 12/8/17.
 */
public class QuestionNaireDataWriter extends Thread {

    Connection con;
    List<Object> list;


    public QuestionNaireDataWriter(Connection con, List<Object> list)
    {
        this.con = con;
        this.list = list;

    }
    public void run()
    {

        try {
            QuestionNaireRandomizer qusnaire = new QuestionNaireRandomizer(con);
            list = qusnaire.getRandomizedList(list);
        for(Object qn :list) {
            System.out.println("In new thread");
            PreparedStatement statement = con.prepareStatement("insert into questionnaire values(?,?) ");
            statement.setLong(1,((QuestionNaire)qn).getProgramId());
            statement.setString(2, String.valueOf(((QuestionNaire)qn).getQuestions()));
            statement.execute();
            System.out.println("Executed successfully");
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
