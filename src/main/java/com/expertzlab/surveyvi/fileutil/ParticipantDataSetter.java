package com.expertzlab.surveyvi.fileutil;

import com.expertzlab.surveyvi.model.Participant;
import com.expertzlab.surveyvi.model.QuestionNaire;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by preethup on 11/8/17.
 */
class ParticipantDataSetter extends DataSetter{

    Class clazz;
    String[] hArray;
    String[] rArray;

    ParticipantDataSetter(Class clazz, String[] hArray, String[] rArray) {
        this.clazz =clazz;
        this.hArray = hArray;
        this.rArray = rArray;
    }
    public Participant run() {
        Participant pt =null;
        Class<?> loadedClass = null;
        try {
            //loadedClass = Class.forName(clazz.getName());
            pt = (Participant) clazz.newInstance();
            for(int i = 0; i< hArray.length; i++) {

                Method m = clazz.getMethod("set" +capitalizeFirstLetter( hArray[i]), String.class);
                m.invoke(pt, rArray[i]);
            }
        
        } catch (IllegalAccessException e) {
            System.out.println(e);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return pt;
    }

    public String capitalizeFirstLetter(String str){
        String ch = str.substring(0,1);
        String remStr= str.substring(1);
        String result= ch.toUpperCase()+remStr;
        return result;
    }
}