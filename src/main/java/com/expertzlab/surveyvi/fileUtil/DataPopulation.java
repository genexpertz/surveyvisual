package com.expertzlab.surveyvi.fileUtil;

import com.expertzlab.surveyvi.fileUtil.LoadSampleData;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * Created by gireeshbabu on 10/08/17.
 */
public class DataPopulation {
    static Map map = new HashMap();
    static File file;
    public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        file = new File("classtype-datafile-mapping.properties");
        Scanner s = new Scanner(file);
        while (s.hasNext())
        {
            String line = s.nextLine();
            String[] strArray = line.split("=");
            Class clazz = Class.forName(strArray[0]);
            LoadSampleData ld = new LoadSampleData(strArray[1],clazz);
            List list = ld.loadData();
            map.put(clazz,list);
        }


    }
}
