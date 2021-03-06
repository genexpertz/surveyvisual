package com.expertzlab.surveyvi.fileutil;

import com.expertzlab.surveyvi.model.Event;
import com.expertzlab.surveyvi.model.Participant;

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
    ResultSet res;
    PreparedStatement statement;

    public boolean hasNext() {

        try {
            return res.next();
        } catch (SQLException e) {
            return false;
        }
    }

    public ParticipantDataReader(Connection con, long id, String all)
    {

        this.con = con;
    }
    public void loadParticipantList() throws SQLException {
        statement = con.prepareStatement("select * from participant");
        res = statement.executeQuery();

    }

    public void loadAttendedParticipantList(long eventId) throws SQLException {
        statement = con.prepareStatement("select p.id, p.name, p.age, p.gender, p.address from participant p " +
                "join attendance a on  p.id = a.participantId where eventId=?");
        statement.setLong(1,eventId);
        res = statement.executeQuery();

    }

    public void close() throws SQLException{
        res.close();
        statement.close();
        System.out.println("Executed successfully");
    }

    public Participant get() throws SQLException {
        String[] hArray = prepareParticipantHeaderArray();
        String[] rArray = new String[5];

        prepareParticipantArray(rArray,res);
        ParticipantDataSetter eds = new ParticipantDataSetter(Participant.class,hArray,rArray);
        Participant p = eds.run();
        return p;
    }


    private void prepareParticipantArray(String[] rArray, ResultSet res) throws SQLException {
        rArray[0] = String.valueOf(res.getInt("id"));
        rArray[1] = res.getString("name");
        rArray[2] = String.valueOf( res.getInt("age"));
        rArray[3] = res.getString("gender");
        rArray[4] = res.getString("address");


    }

    private String[] prepareParticipantHeaderArray(){
        String[] hArray = new String[5];
        hArray[0]= "id";
        hArray[1]="name";
        hArray[2]="age";
        hArray[3]="gender";
        hArray[4]="address";
        return  hArray;
    }
/*
    public List getAllParticipant() throws SQLException {
        List<Participant> list1 = new ArrayList();
        PreparedStatement statement = con.prepareStatement("select * from participant");
        ResultSet res1 = statement.executeQuery();
        //Iterator itr =res1.Iterator();
        Participant pt = null;
        while (res1.next()){
            pt = new Participant();
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
*/
    public static Iterator iterator() {
        return null;
    }
}


