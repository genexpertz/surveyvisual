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
    private static final String EVENT = "com.expertzlab.surveyvi.model.Event";
    private static final String COMPANY = "com.expertzlab.surveyvi.model.Company";
    private static final String USER = "com.expertzlab.surveyvi.model.User";
    private static final String QUESTION = "com.expertzlab.surveyvi.model.Question";
    private static final String QUESTIONNAIRE = "com.expertzlab.surveyvi.model.Questionnaire";
    private static final String ANSWER = "com.expertzlab.surveyvi.model.Answer";
    private static final String OPTION = "com.expertzlab.surveyvi.model.Option";
    private static final String ATTENDANCE = "com.expertzlab.surveyvi.model.Attendance";



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
            else if (EVENT.equals(entry.getKey())) {
                EventDataWriter edw = new EventDataWriter(con, entry.getValue());
                edw.start();
            }
            else if (COMPANY.equals(entry.getKey())) {
                CompanyDataWriter cdw = new CompanyDataWriter(con, entry.getValue());
                cdw.start();
            }
            else if (USER.equals(entry.getKey())) {
                UserDataWriter udw = new UserDataWriter(con, entry.getValue());
                udw.start();
            }
            else if (QUESTION.equals(entry.getKey())) {
                QuestionDataWriter qdw = new QuestionDataWriter(con, entry.getValue());
                qdw.start();
            }
            else if (QUESTIONNAIRE.equals(entry.getKey())) {
                QuestionNaireDataWriter qadw = new QuestionNaireDataWriter(con, entry.getValue());
                qadw.start();
            }
            else if (ANSWER.equals(entry.getKey())) {
                AnswerDataWriter ansdw = new AnswerDataWriter(con, entry.getValue());
                ansdw.start();
            }
            else if (EVENT.equals(entry.getKey())) {
                EventDataWriter evtdw = new EventDataWriter(con, entry.getValue());
                evtdw.start();
            }
            else if (OPTION.equals(entry.getKey())) {
                OptionDataWriter opdw = new OptionDataWriter(con, entry.getValue());
                opdw.start();
            }
            else if (ATTENDANCE.equals(entry.getKey())) {
                //Use Event Reader
                EventDataReader edr = new EventDataReader(con,projectId,list);
                //Use Participant reader passing event id get attendedParticipant list
                ParticipantDataReader pdr =  new ParticipantDataReader(con,eventId,list);
                AttendanceDataWriter attdw = new AttendanceDataWriter(con, partlist, eventlist,questionlist);
                attdw.start();
            }

            }
        }
    }

