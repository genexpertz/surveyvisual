package com.expertzlab.surveyvi.fileutil;

import com.expertzlab.surveyvi.model.Event;

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
public class EventRandomizer {
    int pos1;
    int pos2;
    int recordcount =50;
    long lastId = 1;

    EventRandomizer(Connection con ) throws SQLException {
        Statement stmt = con.createStatement();
        ResultSet res = stmt.executeQuery("Select max(id) from event");
        while (res.next()){
            lastId = res.getLong(1);
        }
    }
    public List getRandomizedList(List list) {
        List l1 = new ArrayList(recordcount);

        for (long i = lastId+1; i <= recordcount; i++) {

            Random r = new Random();
            pos1 = r.nextInt(list.size());
            Event p1 = (Event) list.get(pos1);
            pos2 = r.nextInt(list.size());
            Event p2 = (Event) list.get(pos2);
            Event p3 = new Event();
            p3.setId(i);
            p3.setProjectId(p1.getProjectId());
            p3.setAgentId(p1.getAgentId());
            l1.add(p3);
        }

        return l1;
    }
}
