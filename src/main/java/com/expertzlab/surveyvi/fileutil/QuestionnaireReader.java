package com.expertzlab.surveyvi.fileutil;

import com.expertzlab.surveyvi.model.Event;
import com.expertzlab.surveyvi.model.Project;
import com.expertzlab.surveyvi.model.Question;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by preethup on 15/9/17.
 */
public class QuestionnaireReader {
    Connection con;
  public List  getQuestions(Event id) throws SQLException {
    List list = new ArrayList();
    PreparedStatement statement = con.prepareStatement("select * from question");
    ResultSet res = statement.executeQuery();
    String[] hArray = prepareQuestionHeaderArray();
    String[] rArray = new String[10];
    while (res.next()){

      prepareQuestionRecordArray(rArray,res);
      QuestionDataSetter pds = new QuestionDataSetter(Question.class,hArray,rArray);
      Question q = pds.run();
      list.add(q);
    }
    res.close();
    System.out.println("Executed successfully");

    return list;
  }

  private void prepareQuestionRecordArray(String[] rArray, ResultSet res) throws SQLException {
    rArray[0] = res.getString("id");
    rArray[1] = res.getString("description");
  }

  private String[] prepareQuestionHeaderArray(){
    String[] hArray = new String[10];
    hArray[0]= "id";
    hArray[1]= "description";
    return  hArray;
  }

  public void getAllParticipant(Project id) throws SQLException {
    List<Question> list1 = new ArrayList();
    PreparedStatement statement = con.prepareStatement("select * from question");
    ResultSet res1 = statement.executeQuery();
    //Iterator itr =res1.Iterator();
    Question qs = null;
    while (res1.next()){
      qs= new Question();
      qs.setId(res1.getInt("Id"));
      qs.setDescription(res1.getString("description"));
      list1.add(qs);
    }
    System.out.println("Executed successfully");
  }

  public static Iterator iterator() {
    return null;
  }
}

