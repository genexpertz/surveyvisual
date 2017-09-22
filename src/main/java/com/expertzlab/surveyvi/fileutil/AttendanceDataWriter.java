package com.expertzlab.surveyvi.fileutil;


import com.expertzlab.surveyvi.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Created by preethup on 21/8/17.
 */
public class AttendanceDataWriter extends Thread {

    Connection con;
    long proid;
    long partid;
    long eid;

    public AttendanceDataWriter(Connection con, long eid, long  proid, long partid) {
        this.con = con;
        this.eid = eid;
        this.proid = proid;
        this.partid = partid;

    }


        public void markAttendance () throws SQLException{

            PreparedStatement statement = con.prepareStatement("insert into attendance(participantId," +
                    "eventId, attendance, projectId) values(?,?,?,?) ");

            String attendanceStataus = null;
            Random r = new Random();
            int pos1 = r.nextInt(10);
            int pos2 = r.nextInt(10);
            if (pos1>pos2) {
                attendanceStataus = "yes";
            }
            else {
                attendanceStataus = "no";
            }
            statement.setLong(1,partid);
            statement.setLong(2,eid);
            statement.setString(3,attendanceStataus);
            statement.setLong(4,proid);

            statement.execute();
            System.out.println("Executed successfully");
        }
    }
