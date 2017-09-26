package com.expertzlab.surveyvi.fileutil;

import com.expertzlab.surveyvi.model.Event;
import com.expertzlab.surveyvi.model.Participant;
import com.expertzlab.surveyvi.model.Question;

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
public class QuestionDataReader {


    Connection con;
    ResultSet res;

    public boolean hasNext() {

        try {
            return res.next();
        } catch (SQLException e) {
            return false;
        }
    }

    public QuestionDataReader(Connection con)
    {

        this.con = con;
    }
    public List getQuestionList() throws SQLException {
        PreparedStatement statement = con.prepareStatement("select * from question");
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
        String[] hArray = prepareQuestionHeaderArray();
        String[] rArray = new String[10];

        prepareQuestionArray(rArray,res);
        EventDataSetter eds = new EventDataSetter(Participant.class,hArray,rArray);
        Event p = eds.run();
        return p;
    }


    private void prepareQuestionArray(String[] rArray, ResultSet res) {
    }

    private String[] prepareQuestionHeaderArray(){
        String[] hArray = new String[6];
        hArray[0]= "id";
        hArray[1]="description";
        hArray[2]="option1";
        hArray[3]="option2";
        hArray[4]="option3";
        hArray[5]="option4";
        return  hArray;
    }

    public List getAllQuestion() throws SQLException {
        List<Question> list1 = new ArrayList();
        PreparedStatement statement = con.prepareStatement("select * from question");
        ResultSet res1 = statement.executeQuery();
        //Iterator itr =res1.Iterator();
        Question pt = null;
        while (res1.next()){
            pt = new Question();
            pt.setId(res1.getInt("id"));
            pt.setDescription(res1.getString("description"));
            pt.setOption1(res1.getString("option1"));
            pt.setOption2(res1.getString("option2"));
            pt.setOption3(res1.getString("option3"));
            pt.setOption4(res1.getString("option4"));
            list1.add(pt);
        }
        System.out.println("Executed successfully");
        return list1;
    }

    public static Iterator iterator() {
        return null;
    }
}


