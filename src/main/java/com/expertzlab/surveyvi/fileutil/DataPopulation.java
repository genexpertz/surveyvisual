package com.expertzlab.surveyvi.fileutil;

import com.expertzlab.surveyvi.genutil.DBConnectionManager;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by gireeshbabu on 10/08/17.
 */
public class DataPopulation {
    static Map map = new LinkedHashMap();
    static File file;
    public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, SQLException, InterruptedException {
        file = new File("classtype-datafile-mapping.properties");
        Scanner s = new Scanner(file);
        while (s.hasNext())
        {
            String line = s.nextLine();
            String[] strArray = line.split("=");
            Class clazz = Class.forName(strArray[0]);
            if(!clazz.getName().equals("com.expertzlab.surveyvi.model.Attendance")) {
                LoadSampleData ld = new LoadSampleData(strArray[1], clazz);
                List list = ld.loadData();
                System.out.println("Class is -" + clazz);
                System.out.println("List is -" + list);
                map.put(clazz.getName(), list);
            }
        }
        WriteSampleData wsd = new WriteSampleData(map);
        wsd.writeData();

        //while(true) {
        //    System.out.println(Thread.activeCount());
        //    Thread.sleep(1000*30);
        //    if(Thread.activeCount()<2){
        //        break;
        //}
        //  }

        Connection con = DBConnectionManager.getConnection();
        AttendanceService attendanceService = new AttendanceService(con);
        attendanceService.markAttendance();
    }
}
