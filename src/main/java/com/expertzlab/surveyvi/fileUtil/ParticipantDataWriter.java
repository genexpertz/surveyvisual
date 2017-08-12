package com.expertzlab.surveyvi.fileUtil;

import com.expertzlab.surveyvi.model.Participant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Created by preethup on 12/8/17.
 */
public class ParticipantDataWriter extends DataWriter {

    Connection con;
    List<Object> list;


    public ParticipantDataWriter(Connection con, List<Object> list)
    {
        this.con = con;
        this.list = list;

    }
    public void run()
    {

        try {
        for(Object pt : list) {

            PreparedStatement statement = con.prepareStatement("insert into participant values(?????) ");

                statement.setString(1,((Participant)pt).getName());

            statement.setInt(2,((Participant)pt).getAge());
            statement.setString(3,((Participant)pt).getGender());
            statement.setString(4,((Participant)pt).getAddress());
            statement.execute();
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
