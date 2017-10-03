package com.expertzlab.surveyvi.fileutil;

import com.expertzlab.surveyvi.model.Agent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by preethup on 21/8/17.
 */
public class AgentDataWriter extends Thread{
    Connection con;
    List<Object> list;


    public AgentDataWriter(Connection con, List<Object> list)
    {
        this.con = con;
        this.list = list;

    }
    public void run()
    {

        try {
            AgentRandomizer ar = new AgentRandomizer(con);
            list = ar.getRandomizedList(list);
            for(Object agt :list) {
                System.out.println("Agent -"+agt);
                System.out.println("In new Agent thread");
                PreparedStatement statement = con.prepareStatement("insert into agent values(?,?) ");
                statement.setLong(1,((Agent)agt).getId());
                statement.setString(2,((Agent)agt).getName());
                //statement.setLong(3,((Agent)agt).getProjectId());
                statement.execute();
                System.out.println("Agent Executed successfully");
            }
        } catch (SQLException e) {
            new RuntimeException("Agent Write",e);
        }
    }
}
