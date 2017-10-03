package com.expertzlab.surveyvi.fileutil;

import com.expertzlab.surveyvi.model.Participant;

import java.sql.*;
import java.util.List;
import java.util.Random;

/**
 * Created by preethup on 12/8/17.
 */
public class ParticipantDataWriter extends Thread {

    int pos1;
    int pos2;
    Connection con;
    List<Object> list;


    public ParticipantDataWriter(Connection con, List list) {
        this.con = con;
        this.list = list;

    }

    public void run() {

        try {
            ParticipantRandomizer pr = new ParticipantRandomizer(con);
            list = pr.getRandomizedList(list);
            for (Object pt : list) {
                System.out.println("In participant thread");
                PreparedStatement statement = con.prepareStatement("insert into participant values(?,?,?,?,?) ");
                statement.setLong(1, ((Participant) pt).getId());
                statement.setString(2, ((Participant) pt).getName());
                statement.setInt(3, ((Participant) pt).getAge());
                statement.setString(4, ((Participant) pt).getGender());
                statement.setString(5, ((Participant) pt).getAddress());
                statement.execute();
                System.out.println("Participant Executed successfully");
            }
        } catch (SQLException e) {
            new RuntimeException("Participant Write",e);
        }
    }

    public void markAttendance(long id) throws SQLException {

        //Exeutequery to store the attendance randomely (true / false)
        Random r = new Random();
        pos1 = r.nextInt(list.size());
        pos2 = r.nextInt(list.size());
        if (pos1 > pos2) {
            PreparedStatement statement = con.prepareStatement("insert into attendance(attendance) values(yes)");
            statement.execute();
        }
        else{
            PreparedStatement statement = con.prepareStatement("insert into attendance(attendance) values(no)");
            statement.execute();
        }

    }
}