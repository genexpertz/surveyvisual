package com.expertzlab.surveyvi.fileutil;

import com.expertzlab.surveyvi.model.Participant;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.*;

/**
 * Created by preethup on 17/8/17.
 */
public class writeSampleDataTest {
    Map pmap = new HashMap();

    @Before
    public void setPmap(){
        List list = new ArrayList();
        list.add(createParticipantForTest());
        list.add(createParticipantForTest());
        pmap.put(Participant.class.getName(),list);
    }
    public Participant createParticipantForTest(){
        Participant pt = new Participant();
        pt.setName("preethu"+ new Random().nextInt(10));
        pt.setAge(23);
        pt.setGender("female");
        pt.setAddress("cherthala"+new Random().nextInt(10));
        return pt;
    }
    @Test
    public void testWriteData() throws SQLException {
        WriteSampleData wsd = new WriteSampleData(pmap);
        wsd.writeData();
    }
}
