package com.expertzlab.surveyvi.fileutil;

import com.expertzlab.surveyvi.model.Participant;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gireeshbabu on 10/08/17.
 */
public class LoadSampleData {

    String fileName;
    FileReader fileReader;
    BufferedReader bfr;
    Class clazz;
    File file = null;
    char[] chArray = new char[100];

    public LoadSampleData(String fileName, Class clazz) throws FileNotFoundException {

       file = new File(fileName);
        this.fileName = fileName;
        fileReader = new FileReader(file);
        bfr = new BufferedReader(fileReader);
        this.clazz = clazz;

    }

    public List loadData() throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        List arrayList = new ArrayList();
       String header = readHeader();
       String[] harray = null;
       if(header != null) {
           harray = header.split("\\|");
       }
       Participant pt = null;
       String record = null;
       int count = 0;
       while(( record = readData()) != null) {

           String[] rArray = record.split("\\|");
           DataSetter ds = null;
           switch (clazz.getName()){
               case "com.expertzlab.surveyvi.model.Participant":{
                   ds = new ParticipantDataSetter(clazz, harray, rArray);
               }
           }
           count++;
           pt = ds.run();
           pt.setId(count);
           arrayList.add(pt);
       }
        return arrayList;
    }

    private String readHeader() throws IOException {
              String line = bfr.readLine();
        return line;
    }

    private String readData() throws IOException {
        String line = bfr.readLine();
        return line;
    }
}
