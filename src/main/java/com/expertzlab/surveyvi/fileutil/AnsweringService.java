package com.expertzlab.surveyvi.fileutil;


import com.expertzlab.surveyvi.model.Event;
import com.expertzlab.surveyvi.model.Participant;

import java.sql.Connection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by preethup on 15/9/17.
 */

public class AnsweringService{

    Connection con;
    List event;
    List participant;
    List questions;

    public AnsweringService(Connection con, List event, List participant, List questions){

    }

    Iterator eventitr;
    Iterator participantitr;
    Iterator questionitr;

    public void answerQuestion(String eventId, String particpantid){

        eventitr = event.iterator();
        while (eventitr.hasNext()){

            participantitr = participant.iterator();
                while (participantitr.hasNext()){


                }

        }

    }
}
