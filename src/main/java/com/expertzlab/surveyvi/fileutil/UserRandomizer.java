package com.expertzlab.surveyvi.fileutil;

import com.expertzlab.surveyvi.model.Participant;
import com.expertzlab.surveyvi.model.User;

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
public class UserRandomizer {
    int pos1;
    int pos2;
    int recordcount =10;
    long lastId = 0;

    public UserRandomizer(Connection con ) throws SQLException {
        Statement stmt = con.createStatement();
        ResultSet res = stmt.executeQuery("Select max(id) from user");
        while (res.next()){
            lastId = res.getLong(1);
        }
    }
   public List getRandomizedList(List list) {
       List l1 = new ArrayList(recordcount);

       int size = list.size()>0? list.size(): 1;

       for (long i = lastId+1; i <= recordcount; i++) {

           Random r = new Random();
           pos1 = r.nextInt(size);
           User p1 = (User) list.get(pos1);
           pos2 = r.nextInt(size);
           User p2 = (User) list.get(pos2);
           User p3 = new User();
           p3.setId(i);
           p3.setFirstName(p1.getFirstName());
           p3.setLastName(p1.getLastName());
           p3.setAge(pos1 > pos2 ? p1.getAge() : p2.getAge());
           p3.setUsername(p1.getUsername());
           p3.setPassword(p1.getPassword());
           l1.add(p3);
       }

           return l1;
       }

}
