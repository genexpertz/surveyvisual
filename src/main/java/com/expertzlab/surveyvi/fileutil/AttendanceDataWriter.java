package com.expertzlab.surveyvi.fileutil;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

/**
 * Created by preethup on 21/8/17.
 */
public class AttendanceDataWriter extends Thread {

<<<<<<< HEAD
//    Connection con;
//    long proid;
//    long partid;
//    long eid;
//
//    public AttendanceDataWriter(Connection con, long eid, long  proid, long partid) {
//        this.con = con;
//        this.eid = eid;
//        this.proid = proid;
//        this.partid = partid;
=======
    Connection con;
    long projId;
    long partcipId;
    long eid;

    public AttendanceDataWriter(Connection con, long projid, long  partcId, long evtId) {
        this.con = con;
        this.eid = evtId;
        this.projId = projid;
        this.partcipId = partcId;
>>>>>>> 5a568a4a3e0899184f6a34a2dd0b12b1d6436894

    }


<<<<<<< HEAD
//        public void markAttendance () throws SQLException{
//
//            PreparedStatement statement = con.prepareStatement("insert into attendance(participantId," +
//                    "eventId, attendance, projectId) values(?,?,?,?) ");
//
//            String attendanceStatus = null;
//            Random r = new Random();
//            int pos1 = r.nextInt(10);
//            int pos2 = r.nextInt(10);
//            if (pos1>pos2) {
//                attendanceStatus = "yes";
//            }
//            else {
//                attendanceStatus = "no";
//            }
//            statement.setLong(1,partid);
//            statement.setLong(2,eid);
//            statement.setString(3,attendanceStatus);
//            statement.setLong(4,proid);
//            statement.execute();
//            System.out.println("Attendance Executed successfully");
//
//        }
//    }
=======
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
            System.out.println("Attendance Executed successfully for: partcipId:"+ partcipId +
                    ",attendance status:"+attendanceStataus);

        }
    }
>>>>>>> 5a568a4a3e0899184f6a34a2dd0b12b1d6436894
