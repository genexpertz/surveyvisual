package com.expertzlab.surveyvi.fileutil;

import com.expertzlab.surveyvi.model.Company;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by preethup on 22/8/17.
 */
public class CompanyRandomizer {
    int pos1;
    int pos2;
    int recordcount =1;
    long lastId = 1;

    public CompanyRandomizer(Connection con ) throws SQLException {
        Statement stmt = con.createStatement();
        ResultSet res = stmt.executeQuery("Select max(id) from company");
        while (res.next()){
            lastId = res.getLong(1);
        }
    }
    public List getRandomizedList(List list) {
        List l1 = new ArrayList(recordcount);
        for (long i = lastId+1; i <= recordcount; i++) {

            Random r = new Random();
            pos1 = r.nextInt(list.size());
            Company p1 = (Company) list.get(pos1);
            pos2 = r.nextInt(list.size());
            Company p2 = (Company) list.get(pos2);
            Company p3 = new Company();
            p3.setId(i);
            p3.setName(p1.getName() + " " + p2.getName() + pos1);
            p3.setAddress(p1.getAddress());
            l1.add(p3);
        }

        return l1;
    }

}
