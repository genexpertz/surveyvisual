package com.expertzlab.surveyvi.fileutil;

import com.expertzlab.surveyvi.model.Company;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by preethup on 22/8/17.
 */
public class CompanyDataWriter extends Thread {
    Connection con;
    List<Object> list;


    public CompanyDataWriter(Connection con, List<Object> list)
    {
        this.con = con;
        this.list = list;

    }
    public void run()
    {

        try {
            CompanyRandomizer cr = new CompanyRandomizer(con);
            list = cr.getRandomizedList(list);
            for(Object com :list) {
                System.out.println("In Company thread");
                PreparedStatement statement = con.prepareStatement("insert into company values(?,?,?)");
                statement.setLong(1,((Company)com).getId());
                statement.setString(2,((Company)com).getName());
                statement.setString(3,((Company)com).getAddress());
                statement.execute();
                statement.close();
                System.out.println("Company Executed successfully");
            }
        } catch (SQLException e) {
            new RuntimeException("Company Write",e);
        }
    }

}
