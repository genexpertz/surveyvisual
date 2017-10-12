package com.expertzlab.surveyvi.fileutil;

import com.expertzlab.surveyvi.model.QuestionNaire;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by preethup on 19/8/17.
 */
public class QuestionNaireRandomizer {
    int pos1;
    int pos2;
    int recordcount =1;
    long lastId = 0;

    public QuestionNaireRandomizer(Connection con ) throws SQLException {
        Statement stmt = con.createStatement();
        ResultSet res = stmt.executeQuery("Select max(id) from questionnaire");
        while (res.next()){
            lastId = res.getLong(1);
        }
    }
   public List getRandomizedList(List list) {
       List l1 = new ArrayList(recordcount);

       for (long i = lastId+1; i <= recordcount; i++) {

           Random r = new Random();
           pos1 = r.nextInt(list.size());
           QuestionNaire p1 = (QuestionNaire) list.get(pos1);
           pos2 = r.nextInt(list.size());
           QuestionNaire p2 = (QuestionNaire) list.get(pos2);
           QuestionNaire p3 = new QuestionNaire();
           p3.setProgramId(i);
           p3.setQuestions(p1.getQuestions());
           l1.add(p3);
       }

           return l1;
       }

}
