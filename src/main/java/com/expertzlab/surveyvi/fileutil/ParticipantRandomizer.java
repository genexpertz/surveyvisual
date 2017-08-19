package com.expertzlab.surveyvi.fileutil;

import com.expertzlab.surveyvi.model.Participant;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by preethup on 19/8/17.
 */
public class ParticipantRandomizer {
    int pos1;
    int pos2;
    int recordcount =1000;


   public List getRandomizedList(List list) {
       List l1 = new ArrayList(recordcount);

       for (int i = 1; i <= recordcount; i++) {

           Random r = new Random();
           pos1 = r.nextInt(list.size());
           Participant p1 = (Participant) list.get(pos1);
           pos2 = r.nextInt(list.size());
           Participant p2 = (Participant) list.get(pos2);
           Participant p3 = new Participant();
           p3.setId(i);
           p3.setName(p1.getName() + " " + p2.getName() + pos1);
           p3.setAge(pos1 > pos2 ? p1.getAge() : p2.getAge());
           p3.setGender(pos1 < pos2 ? p1.getGender() : p2.getGender());
           p3.setAddress(p1.getAddress() + " " + pos2);
           l1.add(p3);
       }

           return l1;
       }

}
