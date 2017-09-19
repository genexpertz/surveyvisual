package com.expertzlab.surveyvi.fileutil;

import com.expertzlab.surveyvi.model.Event;
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

    public AttendanceService(Connection con) {
        this.con = con;
    }

    public void close() throws SQLException{
        pgdr.close();
        prdr.close();
    }

    public void markAttendance() {

         pgdr = new ProgramDataReader(con);

        while (pgdr.hasNext()) {
            Program p = pgdr.get();
            prdr = new ProjectDataReader(con, p.getId());
            while (prdr.hasNext()) {
                Project pj = prdr.get();
                EventDataReader edr = new EventDataReader(con, pj.getId());
                while (edr.hasNext()) {
                    Event e = edr.get();
                    ParticipantDataReader pdr = new ParticipantDataReader(con, e.id, "ALL");
                    while (pdr.hasNext()) {
                        ParticipantDataWriter pd = new ParticipantDataWriter();
                        pd.markAttendance(e.getId());
                    }
                }
            }
        }
    }
}
