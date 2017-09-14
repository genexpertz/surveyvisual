package com.expertzlab.surveyvi.fileutil;

import com.expertzlab.surveyvi.model.Agent;
import com.expertzlab.surveyvi.model.Attendance;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by preethup on 21/8/17.
 */
public class AttendanceRandomizer {
    int pos1;
    int pos2;
    int recordcount =100;
    long lastId = 0;

    public AttendanceRandomizer(Connection con ) throws SQLException {
        Statement stmt = con.createStatement();
        ResultSet res = stmt.executeQuery("Select max(id) from attendance");
        while (res.next()){
            lastId = res.getLong(1);
        }
    }
    public List getRandomizedList(List list) {
        List l1 = new ArrayList(recordcount);

        for (long i = lastId+1; i <= recordcount; i++) {

            Random r = new Random();
            pos1 = r.nextInt(list.size());
            Attendance p1 = (Attendance) list.get(pos1);
            pos2 = r.nextInt(list.size());
            Attendance p2 = (Attendance) list.get(pos2);
            Attendance p3 = new Attendance();
            p3.setId(i);
            p3.setParticipantId((pos1 > pos2 ? p1.getParticipantId() : p2.getParticipantId()));
            p3.setEventId((pos1 > pos2 ? p1.getEventId() : p2.getEventId()));
            p3.setAttendance(p1.getAttendance());
            l1.add(p3);
        }

        return l1;
    }
}
