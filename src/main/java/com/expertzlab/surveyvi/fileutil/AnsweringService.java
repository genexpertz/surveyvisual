package com.expertzlab.surveyvi.fileutil;


import com.expertzlab.surveyvi.model.Event;
import com.expertzlab.surveyvi.model.Participant;
import com.expertzlab.surveyvi.model.Program;
import com.expertzlab.surveyvi.model.Project;

import java.sql.Connection;
import java.util.Iterator;


/**
 * Created by preethup on 15/9/17.
 */

public class AnsweringService{

    Connection con;

    public AnsweringService(Connection con, Event e, Participant pt, QuestionDataReader qdr){
        this.con = con;
    }

    Iterator eventitr;
    Iterator participantitr;
    Iterator questionitr;

    public void answerQuestion(String eventId, String particpantid){

        ProgramDataReader pgdr = new ProgramDataReader(con);

        while (pgdr.hasNext()){
            Program p = pgdr.get();
            ProjectDataReader prdr = new ProjectDataReader(con, p.getId());
            while(prdr.hasNext()){
                Project pj = prdr.get();
                EventDataReader edr = new EventDataReader(con,pj.getId());
                while(edr.hasNext()){
                    Event e = edr.get();
                    ParticipantDataReader pdr =  new ParticipantDataReader(con,e.id,"ATTENDED");
                    while(pdr.hasNext()){
                        Participant pt = pdr.get();
                        QuestionDataReader qdr = new QuestionDataReader(con);
                        AnsweringService ans = new AnsweringService(con,e,pt,qdr);
                    }
                }
            }

        }

    }
}
