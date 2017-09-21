package com.expertzlab.surveyvi.fileutil;

import com.expertzlab.surveyvi.model.Program;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by preethup on 19/9/17.
 */
public class ProgramDataReader {


    Connection con;
    ResultSet res;

    public boolean hasNext() {

        try {
            return res.next();
        } catch (SQLException e) {
            return false;
        }
    }

    public ProgramDataReader(Connection con)
    {

        this.con = con;
    }
    public List getProgramList() throws SQLException {
        PreparedStatement statement = con.prepareStatement("select * from program");
        res = statement.executeQuery();
        List list = new ArrayList();
        list.add(res);

        return list;
    }

    public void close() throws SQLException{
        res.close();
        System.out.println("Executed successfully");
    }

    public Program get(){
        String[] hArray = prepareProgramHeaderArray();
        String[] rArray = new String[10];

        prepareProgramArray(rArray,res);
        ProgramDataSetter pds = new ProgramDataSetter(Program.class,hArray,rArray);
        Program p = pds.run();
        return p;
    }

    private void prepareProgramArray(String[] rArray, ResultSet res) {
    }

    private String[] prepareProgramHeaderArray(){
        String[] hArray = new String[2];
        hArray[0]= "id";
        hArray[1]="name";
        return  hArray;
    }
/*
    public List getAllProgram(Program id) throws SQLException {
        List<Program> list1 = new ArrayList();
        PreparedStatement statement = con.prepareStatement("select * from program");
        ResultSet res1 = statement.executeQuery();
        //Iterator itr =res1.Iterator();
        Program pt = null;
        while (res1.next()){
            pt = new Program();
            pt.setId(res1.getLong("id"));
            pt.setName(res1.getString("name"));
            list1.add(pt);
        }
        System.out.println("Executed successfully");
        return list1;
    }
*/
    public static Iterator iterator() {
        return null;
    }
}
