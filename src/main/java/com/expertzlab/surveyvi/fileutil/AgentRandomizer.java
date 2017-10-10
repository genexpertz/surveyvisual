package com.expertzlab.surveyvi.fileutil;

import com.expertzlab.surveyvi.model.Agent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by preethup on 21/8/17.
 */
public class AgentRandomizer {
    int pos1;
    int pos2;
    int recordcount =10;
    long lastId = 0;

    public AgentRandomizer(Connection con ) throws SQLException {
        Statement stmt = con.createStatement();
        ResultSet res = stmt.executeQuery("Select max(id) from agent");
        while (res.next()){
            lastId = res.getLong(1);
        }
    }
    public List getRandomizedList(List list) {
        List l1 = new ArrayList(recordcount);

        for (long i = lastId+1; i <= recordcount; i++) {

            Random r = new Random();
            pos1 = r.nextInt(list.size());
            Agent p1 = (Agent) list.get(pos1);
            pos2 = r.nextInt(list.size());
            Agent p2 = (Agent) list.get(pos2);
            Agent p3 = new Agent();
            p3.setId(i);
            p3.setName(p1.getName() + " " + p2.getName() + pos1);
            l1.add(p3);
        }

        return l1;
    }
}
