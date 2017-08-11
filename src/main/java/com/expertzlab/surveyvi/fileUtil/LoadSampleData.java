package com.expertzlab.surveyvi.fileUtil;

import com.expertzlab.surveyvi.model.Participant;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gireeshbabu on 10/08/17.
 */
public class LoadSampleData {

    String fileName;
    FileReader fileReader;
    Class clazz;
    File file = null;
    char[] chArray = new char[100];

    public LoadSampleData(String fileName, Class clazz) throws FileNotFoundException {

       file = new File(fileName);
        this.fileName = fileName;
        fileReader = new FileReader(file);
        this.clazz = clazz;

    }

    public List loadData() throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        List arrayList = new ArrayList();
       String header = readHeader();
       String[] harray = null;
       if(header != null) {
           harray = header.split("|");
       }
        Participant pt = null;
       String record = null;

       while(( record = readData()) != null) {

           String[] rArray = record.split("|");
           for(int i=0; i<harray.length; i++) {
               if (clazz.getName().equals("Participant")) {

                   Class<?> loadedClass = Class.forName(clazz.getName());
                   pt = (Participant) loadedClass.newInstance();
               }
               Method m = clazz.getMethod("set" + harray[i], String.class);
               m.invoke(pt, rArray[i]);
           }
           arrayList.add(pt);
       }
        return arrayList;
    }

    private String readHeader() throws IOException {
        int rs = fileReader.read(chArray);
        if(rs > 1){
            return new String(chArray);
        } else {
            return null;
        }
    }

    private String readData() throws IOException {
        return "";
    }
}
