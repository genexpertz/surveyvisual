package com.expertzlab.surveyvi.fileutil;


import com.expertzlab.surveyvi.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

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

            PreparedStatement statement = con.prepareStatement("insert into attendance values(?,?,?)");
            statement.execute();
            System.out.println("Executed successfully");
        }
    }
