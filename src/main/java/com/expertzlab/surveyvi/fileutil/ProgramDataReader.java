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
    PreparedStatement statement;

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
    public void getProgramList() throws SQLException {
        statement = con.prepareStatement("select * from program");
        res = statement.executeQuery();
    }

    public void close() throws SQLException{
        res.close();
        statement.close();
        System.out.println("Executed successfully");
    }

    public Program get() throws SQLException {
        String[] hArray = prepareProgramHeaderArray();
        String[] rArray = new String[2];

        prepareProgramArray(rArray,res);
        ProgramDataSetter pds = new ProgramDataSetter(Program.class,hArray,rArray);
        Program p = pds.run();
        return p;
    }

    private void prepareProgramArray(String[] rArray, ResultSet res) throws SQLException {
        rArray[0] = res.getString(1);
        rArray[1] = res.getString(2);
    }

    private String[] prepareProgramHeaderArray(){
        String[] hArray = new String[2];
        hArray[0]= "id";
        hArray[1]="name";
        return  hArray;
    }

    public static Iterator iterator() {
        return null;
    }
}
