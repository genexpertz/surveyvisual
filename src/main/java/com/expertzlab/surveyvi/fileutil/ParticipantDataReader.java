package com.expertzlab.surveyvi.fileutil;

import com.expertzlab.surveyvi.model.Event;
import com.expertzlab.surveyvi.model.Participant;
import com.expertzlab.surveyvi.model.Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Created by preethup on 13/9/17.
 */
public class ParticipantDataReader {


    Connection con;
    Event eventId;
    List list;

    public ParticipantDataReader(Connection con,Event eventId,List list)
    {

        this.con = con;
        this.eventId = eventId;
        this.list = list;
    }
   public List getAttendedParticipantList(Event eventId) throws SQLException {
       List list = new ArrayList();
       PreparedStatement statement = con.prepareStatement("select * from participant p join attendance a on p.id = a.participantId where a.attendance = yes");
       ResultSet res = statement.executeQuery();
       String[] hArray = prepareParticipantHeaderArray();
       String[] rArray = new String[10];
       while (res.next()){

           prepareParticipantRecordArray(rArray,res);
           ParticipantDataSetter pds = new ParticipantDataSetter(Participant.class,hArray,rArray);
           Participant p = pds.run();
           list.add(p);
       }
       res.close();
       System.out.println("Executed successfully");

       return list;
   }

   private void prepareParticipantRecordArray(String[] rArray, ResultSet res) throws SQLException {
       rArray[0] = res.getString("id");
       rArray[1] = res.getString("name");
   }

   private String[] prepareParticipantHeaderArray(){
       String[] hArray = new String[4];
       hArray[0]= "id";
       hArray[1]="name";
       hArray[2]="age";
       hArray[3]="gender";
       hArray[4]="address";
       return  hArray;
   }

   public List getAllParticipant(Project id) throws SQLException {
       List<Participant> list1 = new ArrayList();
       PreparedStatement statement = con.prepareStatement("select * from participant");
       ResultSet res1 = statement.executeQuery();
       //Iterator itr =res1.Iterator();
        Participant pt = null;
       while (res1.next()){
           pt= new Participant();
           pt.setId(res1.getLong("id"));
           pt.setName(res1.getString("name"));
           pt.setAge(res1.getInt("age"));
           pt.setAddress(res1.getString("address"));
           pt.setGender(res1.getString("gender"));
           list1.add(pt);
       }
       System.out.println("Executed successfully");
       return list1;
   }

    public static Iterator iterator() {
        return null;
    }
}
