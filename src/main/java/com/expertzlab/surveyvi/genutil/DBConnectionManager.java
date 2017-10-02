package com.expertzlab.surveyvi.genutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by admin on 22/09/17.
 */
public class DBConnectionManager {

    public static Connection getConnection() throws SQLException {
<<<<<<< HEAD
       return DriverManager.getConnection("jdbc:mysql://localhost:3306/surveyvisual", "root", "pp");
=======
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/surveyvisual", "root", "AvinRaja001");

>>>>>>> 00a6793c1d4fe9d287fbbb489176c7c977f0631e
    }
}
