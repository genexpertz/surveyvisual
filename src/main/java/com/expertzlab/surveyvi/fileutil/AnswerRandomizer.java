package com.expertzlab.surveyvi.fileutil;

import com.expertzlab.surveyvi.model.Answer;

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
public class AnswerRandomizer {
    int pos1;
    int pos2;
    int recordcount =1000;
    long lastId = 0;

    public AnswerRandomizer(Connection con ) throws SQLException {
        Statement stmt = con.createStatement();
        ResultSet res = stmt.executeQuery("Select max(id) from answer");
        while (res.next()){
            lastId = res.getLong(1);
        }
    }
   public List getRandomizedList(List list) {
       List l1 = new ArrayList(recordcount);

       for (long i = lastId+1; i <= recordcount; i++) {

           Random r = new Random();
           pos1 = r.nextInt(list.size());
           Answer p1 = (Answer) list.get(pos1);
           pos2 = r.nextInt(list.size());
           Answer p2 = (Answer) list.get(pos2);
           Answer p3 = new Answer();
           p3.setId(i);
           p3.setQuestionId(p1.getQuestionId());
           p3.setWeightage(p1.getWeightage());
           l1.add(p3);
       }

           return l1;
       }

}
