package com.expertzlab.surveyvi.fileutil;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

/**
 * Created by preethup on 21/8/17.
 */
public class AttendanceDataWriter extends Thread {


    Connection con;
    long projId;
    long partcipId;
    long eid;

    public AttendanceDataWriter(Connection con, long projid, long  partcId, long evtId) {
        this.con = con;
        this.eid = evtId;
        this.projId = projid;
        this.partcipId = partcId;

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
            statement.setLong(1, partcipId);
            statement.setLong(2,eid);
            statement.setString(3,attendanceStataus);
            statement.setLong(4, projId);
            statement.execute();
            statement.close();
            System.out.println("Attendance Executed successfully for: partcipId:"+ partcipId +
                    ",attendance status:"+attendanceStataus);

        }
    }

