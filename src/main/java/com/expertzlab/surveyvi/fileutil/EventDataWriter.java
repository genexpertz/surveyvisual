package com.expertzlab.surveyvi.fileutil;

import com.expertzlab.surveyvi.model.Event;
import com.expertzlab.surveyvi.model.Program;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by preethup on 23/8/17.
 */
public class EventDataWriter extends Thread {
    Connection con;
    List<Object> list;


    public EventDataWriter(Connection con, List<Object> list)
    {
        this.con = con;
        this.list = list;

    }
    public void run()
    {

        try {
            EventRandomizer er = new EventRandomizer(con);
            list = er.getRandomizedList(list);

            for(Object evt :list) {
                System.out.println("In new thread");
                PreparedStatement statement = con.prepareStatement("insert into event values(?,?,?,?,?,?) ");
                statement.setLong(1,((Event)evt).getId());
                statement.setString(2,((Event)evt).getEventName());
                statement.setString(3,((Event)evt).getPlace());
                statement.setString(4,((Event)evt).getDate());
                statement.setString(5,((Event)evt).getProjectId());
                statement.setString(6,((Event)evt).getAgentId());
                statement.execute();
                System.out.println("Event Executed successfully");
            }
        } catch (SQLException e) {
            new RuntimeException("Event Write",e);
        }
    }
}
