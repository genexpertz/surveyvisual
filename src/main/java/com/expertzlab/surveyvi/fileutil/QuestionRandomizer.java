package com.expertzlab.surveyvi.fileutil;

import com.expertzlab.surveyvi.model.Question;

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
public class QuestionRandomizer {
    int pos1;
    int pos2;
    int recordcount =16;
    long lastId = 0;

    public QuestionRandomizer(Connection con ) throws SQLException {
        Statement stmt = con.createStatement();
        ResultSet res = stmt.executeQuery("Select max(id) from question");
        while (res.next()){
            lastId = res.getLong(1);
        }
    }
   public List getRandomizedList(List list) {
       List l1 = new ArrayList(recordcount);

       for (long i = lastId+1; i <= recordcount; i++) {

           Random r = new Random();
           pos1 = r.nextInt(list.size());
           Question p1 = (Question) list.get(pos1);
           pos2 = r.nextInt(list.size());
           Question p2 = (Question) list.get(pos2);
           Question p3 = new Question();
           p3.setId(p1.getId());
           p3.setDescription(p1.getDescription());
           p3.setOption1(p1.getOption1());
           p3.setOption2(p1.getOption2());
           p3.setOption3(p1.getOption3());
           p3.setOption4(p1.getOption4());
           l1.add(p3);
       }

           return l1;
       }

}
