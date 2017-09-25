package com.expertzlab.surveyvi.fileutil;

import com.expertzlab.surveyvi.model.Event;
import com.expertzlab.surveyvi.model.Participant;
import com.expertzlab.surveyvi.model.Program;
import com.expertzlab.surveyvi.model.Project;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by preethup on 19/9/17.
 */
public class AttendanceService {

    Connection con;
    ProgramDataReader pgdr;
    ProjectDataReader prdr;
    EventDataReader edr;
    ParticipantDataReader pdr;
    AttendanceDataWriter adr;

    public AttendanceService(Connection con) {
        this.con = con;
    }

    public void close() throws SQLException{


    }

    public void markAttendance() throws SQLException{

        pgdr = new ProgramDataReader(con);
        pgdr.getProgramList();
        while (pgdr.hasNext()) {
            Program p = pgdr.get();
            prdr = new ProjectDataReader(con, p.getId());
            prdr.getProjectList();
            while (prdr.hasNext()) {
                Project pj = prdr.get();
                edr = new EventDataReader(con, pj.getId());
                edr.getEventList();
                while (edr.hasNext()) {
                    Event e = edr.get();
                    pdr = new ParticipantDataReader(con, e.id, "ALL");
                    pdr.getParticipantList();
                    while (pdr.hasNext()){
                        Participant pt = pdr.get();
                        adr = new AttendanceDataWriter(con,pj.getId(),pt.getId(),e.getId());
                        adr.markAttendance();
                    }
                }
            }
        }
    }
}
