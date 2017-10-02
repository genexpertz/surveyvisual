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

    public Event get() throws SQLException {
        String[] hArray = prepareEventHeaderArray();
        String[] rArray = new String[6];

        prepareEventArray(rArray,res);
        EventDataSetter eds = new EventDataSetter(Event.class,hArray,rArray);
        Event e = eds.run();
        return e;
    }

    private void prepareEventArray(String[] rArray, ResultSet res) throws SQLException {
        rArray[0] = String.valueOf(res.getInt(1));
        rArray[1] = res.getString(2);
        rArray[2] = res.getString(3);
        rArray[3]  = res.getString(4);
        rArray[4] = String.valueOf(res.getInt(5));
        rArray[5] = String.valueOf(res.getInt(6));
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


    public static Iterator iterator() {
        return null;
    }
}
