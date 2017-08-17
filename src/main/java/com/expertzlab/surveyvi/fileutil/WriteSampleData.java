package com.expertzlab.surveyvi.fileutil;

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

    private static final String PARTICIPANT = "com.expertzlab.surveyvi.model.Participant";
    Map<Class,List> map;
    Connection con;

   public WriteSampleData(Map<Class,List> map) throws SQLException {

        this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/surveyvisual", "root", "pp");
        this.map = map;
    }

    void writeData()
    {
        for (HashMap.Entry<Class,List> entry : map.entrySet()) {
            if (PARTICIPANT.equals(entry.getKey())) {
                    ParticipantDataWriter pdw = new ParticipantDataWriter(con, entry.getValue());
                    pdw.run();
            }
        }
    }

}
