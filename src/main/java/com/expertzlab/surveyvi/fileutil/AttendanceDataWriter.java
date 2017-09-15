package com.expertzlab.surveyvi.fileutil;

import com.expertzlab.surveyvi.model.Agent;
import com.expertzlab.surveyvi.model.Attendance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by preethup on 21/8/17.
 */
public class AttendanceDataWriter extends Thread{
    Connection con;
    List<Object> list;


    public AttendanceDataWriter(Connection con, List<Object> list)
    {
        this.con = con;
        this.list = list;

    }
    public void run()
    {

        try {
            AttendanceRandomizer ar = new AttendanceRandomizer(con);
            list = ar.getRandomizedList(list);
            for(Object att :list) {
                System.out.println("Attendence -"+att);
                System.out.println("In new thread");
                PreparedStatement statement = con.prepareStatement("insert into agent values(?,?) ");
                statement.setLong(1,((Attendance)att).getId());
                statement.setInt(2,((Attendance)att).getParticipantId());
                statement.setInt(3,((Attendance)att).getEventId());
                statement.setString(4,((Attendance)att).getAttendance());
                statement.execute();
                System.out.println("Executed successfully");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
