package com.expertzlab.surveyvi.fileutil;


import com.expertzlab.surveyvi.model.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Random;


/**
 * Created by preethup on 15/9/17.
 */

public class AnsweringService{

    Connection con;

    public AnsweringService(Connection con){
        this.con = con;
    }

    public void answerQuestions() throws SQLException {

        ProgramDataReader pgdr = new ProgramDataReader(con);
        pgdr.getProgramList();
        while (pgdr.hasNext()){
            Program p = pgdr.get();
            ProjectDataReader prdr = new ProjectDataReader(con, p.getId());
            prdr.getProjectListFromProgram();
            while(prdr.hasNext()){
                Project pj = prdr.get();
                EventDataReader edr = new EventDataReader(con,pj.getId());
                edr.getEventListFromProject();
                while(edr.hasNext()){
                    Event e = edr.get();
                    ParticipantDataReader pdr =  new ParticipantDataReader(con,e.id,"ATTENDED");
                    pdr.loadAttendedParticipantList(e.getId());
                    while(pdr.hasNext()){
                        Participant pt = pdr.get();
                        QuestionDataReader qdr = new QuestionDataReader(con);
                        qdr.getQuestionList();
                        while(qdr.hasNext()) {
                            Question q = qdr.get();
                            Answer answer = new Answer();
                            answer.setEventId(e.getId());
                            answer.setOptionId(getOptionRandom(q));
                            answer.setParticipantId(pt.getId());
                            answer.setProgarmId(p.getId());
                            answer.setQuestionId(q.getId());

                            AnswerDataWriter adw = new AnswerDataWriter(con);
                            adw.execute(answer);
                        }
                        qdr.close();

                    }
                    pdr.close();
                }
                edr.close();
            }
            prdr.close();

        }
        pgdr.close();

    }

    public int getOptionRandom(Question q){

        int optioncount = q.getOptionCount();
       int optionId = new Random().nextInt(optioncount);
       if(optionId <=0){
           optionId = 1;
       }
       if(optionId > optioncount){
           optionId = optioncount;
       }
       return optionId;
    }
}
