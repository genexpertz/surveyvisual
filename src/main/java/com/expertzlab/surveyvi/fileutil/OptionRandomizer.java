package com.expertzlab.surveyvi.fileutil;

import com.expertzlab.surveyvi.model.Event;
import com.expertzlab.surveyvi.model.Option;

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
    int recordcount =16;
    long lastId = 1;

    OptionRandomizer(Connection con ) throws SQLException {
        Statement stmt = con.createStatement();
        ResultSet res = stmt.executeQuery("Select max(id) from option");
        while (res.next()){
            lastId = res.getLong(1);
        }
    }
    public List getRandomizedList(List list) {
        List l1 = new ArrayList(recordcount);

        for (long i = lastId+1; i <= recordcount; i++) {

            Random r = new Random();
            pos1 = r.nextInt(list.size());
            Option p1 = (Option) list.get(pos1);
            pos2 = r.nextInt(list.size());
            Option p2 = (Option) list.get(pos2);
            Option p3 = new Option();
            p3.setId(i);
            p3.setQuestionId(p1.getQuestionId());
            p3.setWeight(p1.getWeight());
            l1.add(p3);
        }

        return l1;
    }
}
