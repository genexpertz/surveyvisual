package com.expertzlab.surveyvi.fileutil;

import com.expertzlab.surveyvi.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by preethup on 12/8/17.
 */
public class UserDataWriter extends Thread {

    Connection con;
    List<Object> list;


    public UserDataWriter(Connection con, List<Object> list)
    {
        this.con = con;
        this.list = list;

    }
    public void run()
    {

        try {
            UserRandomizer ur = new UserRandomizer(con);
            list = ur.getRandomizedList(list);
        for(Object pt :list) {
            System.out.println("In new thread");
            PreparedStatement statement = con.prepareStatement("insert into user values(?,?,?,?,?,?) ");
            statement.setLong(1,((User)pt).getId());
            statement.setString(2,((User)pt).getFirstName());
            statement.setString(3,((User)pt).getFirstName());
            statement.setInt(4,((User)pt).getAge());
            statement.setString(5,((User)pt).getUsername());
            statement.setString(6,((User)pt).getPassword());
            statement.execute();
            System.out.println("Executed successfully");
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
