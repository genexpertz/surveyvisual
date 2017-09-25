package com.expertzlab.surveyvi.fileutil;

import com.expertzlab.surveyvi.model.Project;

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
public class ProjectRandomizer {
    int pos1;
    int pos2;
    int recordcount =20;
    long lastId = 1;

    ProjectRandomizer(Connection con ) throws SQLException {
        Statement stmt = con.createStatement();
        ResultSet res = stmt.executeQuery("Select max(id) from project");
        while (res.next()){
            lastId = res.getLong(1);
        }
    }
    public List getRandomizedList(List list) {
        List l1 = new ArrayList(recordcount);

        for (long i = lastId+1; i <= recordcount; i++) {

            Random r = new Random();
            pos1 = r.nextInt(list.size());
            Project p1 = (Project) list.get(pos1);
            pos2 = r.nextInt(list.size());
            Project p2 = (Project) list.get(pos2);
            Project p3 = new Project();
            p3.setId(i);
            p3.setName(p1.getName());
            p3.setProgId(p1.getProgId());
            l1.add(p3);
        }

        return l1;
    }
}
