package com.expertzlab.surveyvi.fileutil;

import com.expertzlab.surveyvi.model.Event;
import com.expertzlab.surveyvi.model.Program;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by preethup on 19/9/17.
 */
public class EventDataReader {


    Connection con;
    ResultSet res;

    public boolean hasNext() {

        try {
            return res.next();
        } catch (SQLException e) {
            return false;
        }
    }

    public EventDataReader(Connection con, long id)
    {

        this.con = con;
    }
    public List getEventList() throws SQLException {
        PreparedStatement statement = con.prepareStatement("select * from event");
        res = statement.executeQuery();
        List list = new ArrayList();
        list.add(res);

        return list;
    }

    public void close() throws SQLException{
        res.close();
        System.out.println("Executed successfully");
    }

    public Event get(){
        String[] hArray = prepareEventHeaderArray();
        String[] rArray = new String[10];

        prepareEventArray(rArray,res);
        EventDataSetter eds = new EventDataSetter(Program.class,hArray,rArray);
        Event p = eds.run();
        return p;
    }

    private void prepareEventArray(String[] rArray, ResultSet res) {
    }

    private String[] prepareEventHeaderArray(){
        String[] hArray = new String[6];
        hArray[0]= "id";
        hArray[1]="name";
        hArray[2]="place";
        hArray[3]="date";
        hArray[4]="projectId";
        hArray[5]="agentId";
        return  hArray;
    }

    /*public List getAllEvent(Program id) throws SQLException {
        List<Event> list1 = new ArrayList();
        PreparedStatement statement = con.prepareStatement("select * from program");
        ResultSet res1 = statement.executeQuery();
        //Iterator itr =res1.Iterator();
        Event pt = null;
        while (res1.next()){
            pt = new Event();
            pt.setId(res1.getLong("id"));
            pt.setEventName(res1.getString("name"));
            pt.setPlace(res1.getString("place"));
            pt.setDate(res1.getString("date"));
            pt.setProjectId(res1.getString("projectId"));
            pt.setAgentId(res1.getString("agentId"));
            list1.add(pt);
        }
        System.out.println("Executed successfully");
        return list1;
    }
*/
    public static Iterator iterator() {
        return null;
    }
}
