package com.expertzlab.surveyvi.fileutil;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by preethup on 11/8/17.
 */
public class WriteSampleData {

    private static final String PARTICIPANT = "com.expertzlab.surveyvi.model.Participant";
    private static final String AGENT = "com.expertzlab.surveyvi.model.Agent";
    private static final String PROGRAM = "com.expertzlab.surveyvi.model.Program";
    private static final String PROJECT = "com.expertzlab.surveyvi.model.Project";
    private static final String COMPANY = "com.expertzlab.surveyvi.model.Company";

    Map<Class,List> map;
    Connection con;

   public WriteSampleData(Map<Class,List> map) throws SQLException {

        this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/surveyvisual", "root", "pp");
        this.map = map;
    }

    void writeData() {
        for (HashMap.Entry<Class, List> entry : map.entrySet()) {
            if (PARTICIPANT.equals(entry.getKey())) {
                ParticipantDataWriter pdw = new ParticipantDataWriter(con, entry.getValue());
                pdw.start();
            } else if (AGENT.equals(entry.getKey())) {
                AgentDataWriter adw = new AgentDataWriter(con, entry.getValue());
                adw.start();
            } else if (PROGRAM.equals(entry.getKey())) {
                ProgramDataWriter pgmdw = new ProgramDataWriter(con, entry.getValue());
                pgmdw.start();
            }else if (PROJECT.equals(entry.getKey())) {
                ProjectDataWriter prodw = new ProjectDataWriter(con, entry.getValue());
                prodw.start();
            }
            else if (COMPANY.equals(entry.getKey())) {
                CompanyDataWriter cdw = new CompanyDataWriter(con, entry.getValue());
                cdw.start();
            }
            }
        }
    }

