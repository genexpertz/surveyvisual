package com.expertzlab.surveyvi.fileutil;

import com.expertzlab.surveyvi.model.Participant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by preethup on 12/8/17.
 */
public class ParticipantDataWriter extends Thread {

    Connection con;
    List<Object> list;


    public ParticipantDataWriter(Connection con, List<Object> list)
    {
        this.con = con;
        this.list = list;

    }
    public void run()
    {

        try {
            ParticipantRandomizer pr = new ParticipantRandomizer(con);
            list = pr.getRandomizedList(list);
        for(Object pt :list) {
            System.out.println("In new thread");
            PreparedStatement statement = con.prepareStatement("insert into participant values(?,?,?,?,?) ");
            statement.setLong(1,((Participant)pt).getId());
            statement.setString(2,((Participant)pt).getName());
            statement.setInt(3,((Participant)pt).getAge());
            statement.setString(4,((Participant)pt).getGender());
            statement.setString(5,((Participant)pt).getAddress());
            statement.execute();
            System.out.println("Executed successfully");
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void markAttendance(){
        //Exeutequery to store the attendance randomely (true / false)
    }

}
