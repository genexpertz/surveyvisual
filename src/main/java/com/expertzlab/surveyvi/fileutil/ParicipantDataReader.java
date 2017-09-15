package com.expertzlab.surveyvi.fileutil;

import com.expertzlab.surveyvi.model.Attendance;
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
public class ParicipantDataReader {


    Connection con;

    public ParicipantDataReader(Connection con)
    {
        this.con = con;

    }
   public List getAttendedParticipantList(Event id) throws SQLException {
       List list = new ArrayList();
       PreparedStatement statement = con.prepareStatement("select * from participant p join attendance a on p.id = a.participantId where a.attendance = yes");
       ResultSet res = statement.executeQuery();
       Iterator itr =res.Iterator();
       while (res.next()){
           list.add(res);
       }
       res.close();
       System.out.println("Executed successfully");

   }

   public void getAllParticipant(Project id) throws SQLException {
       List<Participant> list1 = new ArrayList();
       PreparedStatement statement = con.prepareStatement("select * from participant");
       ResultSet res1 = statement.executeQuery();
       //Iterator itr =res1.Iterator();
        Participant pt = null;
       while (res1.next()){
           pt= new Participant();
           pt.setId(res1.getLong("Id"));
           pt.setName(res1.getString("name"));
           pt.setAge(res1.getInt("age"));
           pt.setAddress(res1.getString("address"));
           pt.setGender(res1.getString("gender"));
           list1.add(pt);
       }
       System.out.println("Executed successfully");
   }

    public static Iterator iterator() {
        return null;
    }
}
