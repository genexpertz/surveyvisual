package com.expertzlab.surveyvi.fileutil;

import com.expertzlab.surveyvi.model.Event;
import com.expertzlab.surveyvi.model.Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * Created by preethup on 13/9/17.
 */
public class ParicipantDataReader {

    Connection con;

    public ParicipantDataReader(Connection con)
    {
        this.con = con;

    }
   public void getAttendedParticipantList(Event id) throws SQLException {

       PreparedStatement statement = con.prepareStatement("select * from participant where attendance = yes");


   }

   public void getAllParticipant(Project id) throws SQLException {
       PreparedStatement statement = con.prepareStatement("select * from participant");

   }
}
