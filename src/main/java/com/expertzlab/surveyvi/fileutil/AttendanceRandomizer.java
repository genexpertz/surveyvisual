package com.expertzlab.surveyvi.fileutil;

import com.expertzlab.surveyvi.model.Attendance;
import com.expertzlab.surveyvi.model.Event;
import com.expertzlab.surveyvi.model.Participant;

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
            Attendance a1 = (Attendance) list.get(pos1);
            pos2 = r.nextInt(list.size());
            Participant p1 = (Participant) list.get(pos2);
            Event e1 = (Event) list.get(pos1) ;
            Attendance p3 = new Attendance();
            p3.setId(i);
            p3.setParticipantId( (int)p1.getId());
            p3.setEventId(e1.getEventId());
            if (pos1>pos2) {
                p3.setAttendance("yes");
            }
            else {
                p3.setAttendance("no");
            }
            l1.add(p3);
        }
        return l1;
    }
}
