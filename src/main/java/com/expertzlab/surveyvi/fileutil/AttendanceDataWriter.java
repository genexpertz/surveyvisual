package com.expertzlab.surveyvi.fileutil;


import com.expertzlab.surveyvi.model.Agent;
import com.expertzlab.surveyvi.model.Attendance;
import com.expertzlab.surveyvi.model.Event;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

/**
 * Created by preethup on 21/8/17.
 */
public class AttendanceDataWriter extends Thread{
    Connection con;
    List<Object> list;
    List event;
    List participant;
    int recordcount =100;
    long lastId = 0;


    public AttendanceDataWriter(Connection con)
    {
        this.con = con;
        this.list = list;

    }
    public void run() {
        Event evt = null;
        Iterator eitr;
        Iterator pitr;

        //Event List Iterator

        eitr = event.iterator();
        while (eitr.hasNext()){

            // Participant Iterator

            pitr = participant.iterator();
            while (pitr.hasNext()){



        for (long i = lastId+1; i <= recordcount; i++) {
            try {
                AttendanceRandomizer ar = new AttendanceRandomizer(con);
                list = ar.getRandomizedList(list);
                for (Object att : list) {
                    System.out.println("Attendence -" + att);
                    System.out.println("In new thread");
                    PreparedStatement statement = con.prepareStatement("insert into attendance values(?,?,?,?) ");
                    statement.setLong(1, ((Attendance) att).getId());
                    statement.setInt(2, ((Attendance) att).getParticipantId());
                    statement.setInt(3, ((Attendance) att).getEventId());
                    statement.setString(4, ((Attendance) att).getAttendance());
                    statement.execute();
                    System.out.println("Executed successfully");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

            }
        }
    }
}
