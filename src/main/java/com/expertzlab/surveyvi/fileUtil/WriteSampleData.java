package com.expertzlab.surveyvi.fileUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by preethup on 11/8/17.
 */
public class WriteSampleData {

    Map<Class,List> map;
    Connection con;

   public WriteSampleData(Map<Class,List> map) throws SQLException {

        this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/surveyvisual", "preethup", "preethup");
        this.map = map;
    }

    void writeData()
    {
        for (HashMap.Entry<Class,List> entry : map.entrySet()) {
            switch (((Class)entry.getKey()).getName()) {
                case "Participant":
                    ParticipantDataWriter pdw = new ParticipantDataWriter(con, entry.getValue());
                    pdw.start();
            }
        }
    }

}
