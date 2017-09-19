package com.expertzlab.surveyvi.fileutil;

import com.expertzlab.surveyvi.model.Event;

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
public class EventDataReader {


    Connection con;

    public EventDataReader(Connection con)
    {
        this.con = con;

    }
   public List EventList(Event id) throws SQLException {
       List list = new ArrayList();
       PreparedStatement statement = con.prepareStatement("select * from event");
       ResultSet res = statement.executeQuery();
       String[] hArray = prepareEventHeaderArray();
       String[] rArray = new String[10];
       while (res.next()){

           prepareEventRecordArray(rArray,res);
           EventDataSetter eds = new EventDataSetter(Event.class,hArray,rArray);
           Event e = eds.run();
           list.add(e);
       }
       res.close();
       System.out.println("Executed successfully");

       return list;
   }

   private void prepareEventRecordArray(String[] rArray, ResultSet res) throws SQLException {
       rArray[0] = res.getString("id");
       rArray[1] = res.getString("eventName");
       rArray[2]= res.getString("place");
       rArray[3]= res.getString("date");
       rArray[4]= res.getString("projectId");
       rArray[5]= res.getString("agentId");
    }


   private String[] prepareEventHeaderArray(){
       String[] hArray = new String[4];
       hArray[0]= "id";
       hArray[1]="eventName";
       hArray[2]="place";
       hArray[3]="date";
       hArray[4]="projectId";
       hArray[5]="agentId";
       return  hArray;
   }

    public static Iterator iterator() {
        return null;
    }
}
