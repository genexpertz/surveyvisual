package com.expertzlab.surveyvi.fileutil;

import com.expertzlab.surveyvi.model.Options;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by preethup on 23/8/17.
 */
public class OptionRandomizer {
    int pos1;
    int pos2;
    int recordcount =20;
    long lastId = 1;

    OptionRandomizer(Connection con ) throws SQLException {
        Statement stmt = con.createStatement();
        ResultSet res = stmt.executeQuery("Select max(id) from options");
        while (res.next()){
            lastId = res.getLong(1);
        }
    }
    public List getRandomizedList(List list) {
        List l1 = new ArrayList(recordcount);

        for (long i = lastId+1; i <= recordcount; i++) {

            Random r = new Random();
            pos1 = r.nextInt(list.size());
            Options p1 = (Options) list.get(pos1);
            pos2 = r.nextInt(list.size());
            Options p2 = (Options) list.get(pos2);
            Options p3 = new Options();
            p3.setId(i);
            p3.setQuestionId(p2.getQuestionId());
            p3.setWeight(p1.getWeight());
            l1.add(p3);
        }

        return l1;
    }
}
