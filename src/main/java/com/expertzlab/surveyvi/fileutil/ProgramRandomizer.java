package com.expertzlab.surveyvi.fileutil;

import com.expertzlab.surveyvi.model.Program;

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
public class ProgramRandomizer {
    int pos1;
    int pos2;
    int recordcount =1;
    long lastId = 1;

    ProgramRandomizer(Connection con ) throws SQLException {
        Statement stmt = con.createStatement();
        ResultSet res = stmt.executeQuery("Select max(id) from program");
        while (res.next()){
            lastId = res.getLong(1);
        }
    }
    public List getRandomizedList(List list) {
        List l1 = new ArrayList(recordcount);

        for (long i = lastId+1; i <= recordcount; i++) {

            Random r = new Random();
            pos1 = r.nextInt(list.size());
            Program p1 = (Program) list.get(pos1);
            pos2 = r.nextInt(list.size());
            Program p3 = new Program();
            p3.setId(i);
            p3.setName(p1.getName());
            l1.add(p3);
        }

        return l1;
    }
}
