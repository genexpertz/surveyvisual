package com.expertzlab.surveyvi.fileutil;

import com.expertzlab.surveyvi.model.Event;
import com.expertzlab.surveyvi.model.Program;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by preethup on 25/8/17.
 */
public class EventDataSetter extends DataSetter{
    Class clazz;
    String[] hArray;
    String[] rArray;

    EventDataSetter(Class clazz, String[] hArray, String[] rArray) {
        this.clazz =clazz;
        this.hArray = hArray;
        this.rArray = rArray;
    }
    public Event run() {
        Event evt =null;
        Class<?> loadedClass = null;
        try {
            loadedClass = Class.forName(clazz.getName());
            evt = (Event) loadedClass.newInstance();
            for(int i = 0; i< hArray.length; i++) {

                Method m = clazz.getMethod("set" +capitalizeFirstLetter( hArray[i]), String.class);
                m.invoke(evt, rArray[i]);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            System.out.println(e);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return evt;
    }

    public String capitalizeFirstLetter(String str){
        String ch = str.substring(0,1);
        String remStr= str.substring(1);
        String result= ch.toUpperCase()+remStr;
        return result;
    }
}
