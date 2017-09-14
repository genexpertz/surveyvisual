package com.expertzlab.surveyvi.fileutil;

import com.expertzlab.surveyvi.model.Event;
import com.expertzlab.surveyvi.model.Participant;
import com.expertzlab.surveyvi.model.Project;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by preethup on 13/9/17.
 */
public class ParicipantDataReader {

    Class clazz;
    String[] hArray;
    String[] rArray;

    ParicipantDataReader(Class clazz, String[] hArray, String[] rArray) {
        this.clazz =clazz;
        this.hArray = hArray;
        this.rArray = rArray;
    }

   public void getAttendedParticipantList(Event id){


   }

   public void getAllParticipant(Project id){

   }
}
