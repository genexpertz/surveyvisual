package com.expertzlab.surveyvi.fileutil;

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
  public void   getQuestions() throws SQLException {
    List list = new ArrayList();
    PreparedStatement statement = con.prepareStatement("select * from question");
    ResultSet res = statement.executeQuery();
    Iterator itr =res.Iterator();
    while (res.next()){
      list.add(res);
    }
    System.out.println("Executed successfully");
    }
}
