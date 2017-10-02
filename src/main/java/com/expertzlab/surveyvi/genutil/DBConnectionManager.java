package com.expertzlab.surveyvi.genutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnectionManager {

    public static Connection getConnection() throws SQLException {
<<<<<<< HEAD

        return DriverManager.getConnection("jdbc:mysql://localhost:3306/surveyvisual", "root", "pp");

=======
       return DriverManager.getConnection("jdbc:mysql://localhost:3306/surveyvisual", "root", "root123");

>>>>>>> 0da65dcfe824a840da5746b89e5b9320e1a8e8cd
    }
}
