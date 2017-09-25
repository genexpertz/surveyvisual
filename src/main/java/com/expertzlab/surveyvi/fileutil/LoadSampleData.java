package com.expertzlab.surveyvi.fileutil;

import com.expertzlab.surveyvi.model.*;

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
       Agent agt = null;
       Project pro = null;
       Program pgm = null;
       Event evt = null;
       Company com =null;
       User usr = null;
       Question qus = null;
       QuestionNaire qusnaire = null;
       Answer ans = null;
       Options op = null;
       Attendance at = null;
       String record = null;
       int count = 1;
       while(( record = readData()) != null) {

           String[] rArray = record.split("\\|");
           DataSetter ds = null;
           switch (clazz.getName()){
               case "com.expertzlab.surveyvi.model.Participant":{
                   ds = new ParticipantDataSetter(clazz, harray, rArray);
                   pt = (Participant) ds.run();
                   pt.setId(count);
                   arrayList.add(pt);
                   break;
               }
               case "com.expertzlab.surveyvi.model.Agent":{
                   ds = new AgentDataSetter(clazz, harray, rArray);
                   agt = (Agent) ds.run();
                   agt.setId(count);
                   arrayList.add(agt);
                   break;
               }
               case "com.expertzlab.surveyvi.model.Program":{
                   ds = new ProgramDataSetter(clazz, harray, rArray);
                   pgm = (Program) ds.run();
                   pgm.setId(count);
                   arrayList.add(pgm);
                   break;
               }
               case "com.expertzlab.surveyvi.model.Project":{
                   ds = new ProjectDataSetter(clazz, harray, rArray);
                   pro = (Project) ds.run();
                   pro.setId(count);
                   arrayList.add(pro);
                   break;
               }
               case "com.expertzlab.surveyvi.model.Event":{
                   ds = new EventDataSetter(clazz, harray, rArray);
                   evt = (Event) ds.run();
                   evt.setId(count);
                   arrayList.add(evt);
                   break;
               }
               case "com.expertzlab.surveyvi.model.Company":{
                   ds = new CompanyDataSetter(clazz, harray, rArray);
                   com = (Company) ds.run();
                   com.setId(count);
                   arrayList.add(com);
                   break;
               }
               case "com.expertzlab.surveyvi.model.User":{
                   ds = new UserDataSetter(clazz, harray, rArray);
                   usr = (User) ds.run();
                   usr.setId(count);
                   arrayList.add(usr);
                   break;
               }
               case "com.expertzlab.surveyvi.model.Question":{
                   ds = new QuestionDataSetter(clazz, harray, rArray);
                   qus = (Question) ds.run();
                   qus.setId(count);
                   arrayList.add(qus);
                   break;
               }
               case "com.expertzlab.surveyvi.model.QuestionNaire":{
                   ds = new QuestionNaireDataSetter(clazz, harray, rArray);
                   qusnaire = (QuestionNaire) ds.run();
                   qusnaire.setId((long) count);
                   arrayList.add(qusnaire);
                   break;
               }
               case "com.expertzlab.surveyvi.model.Answer":{
                   ds = new AnswerDataSetter(clazz, harray, rArray);
                   ans = (Answer) ds.run();
                   ans.setId(count);
                   arrayList.add(ans);
                   break;
               }

               case "com.expertzlab.surveyvi.model.Attendance": {
                   ds = new AttendanceDataSetter(clazz, harray, rArray);
                   at = (Attendance) ds.run();
                   at.setId(count);
                   arrayList.add(op);
                   break;
               }
           }
           count++;

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
