package com.expertzlab.surveyvi.fileutil;

import com.expertzlab.surveyvi.model.TargetClass;

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
public class TargetClassRandomizer {
    int pos1;
    int pos2;
    int recordcount =100;
    long lastId = 0;

    public TargetClassRandomizer(Connection con ) throws SQLException {
        Statement stmt = con.createStatement();
        ResultSet res = stmt.executeQuery("Select max(id) from target");
        while (res.next()){
            lastId = res.getLong(1);
        }
    }
   public List getRandomizedList(List list) {
       List l1 = new ArrayList(recordcount);

       for (long i = lastId+1; i <= recordcount; i++) {

           Random r = new Random();
           pos1 = r.nextInt(list.size());
           TargetClass p1 = (TargetClass) list.get(pos1);
           pos2 = r.nextInt(list.size());
           TargetClass p2 = (TargetClass) list.get(pos2);
           TargetClass p3 = new TargetClass();
           p3.setRefAnsId(i);
           p3.setPercentage(p1.getPercentage());
           l1.add(p3);
       }

           return l1;
       }

}
