package com.expertzlab.surveyvi.genutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by admin on 22/09/17.
 */
public class DBConnectionManager {

    public static Connection getConnection() throws SQLException {
       return DriverManager.getConnection("jdbc:mysql://localhost:3306/surveyvisual", "root", "AvinRaja001");
    }
}
