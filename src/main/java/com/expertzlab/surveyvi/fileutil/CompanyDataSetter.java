package com.expertzlab.surveyvi.fileutil;

import com.expertzlab.surveyvi.model.Company;
import com.expertzlab.surveyvi.model.QuestionNaire;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by preethup on 22/8/17.
 */
public class CompanyDataSetter extends DataSetter{
    Class clazz;
    String[] hArray;
    String[] rArray;

    CompanyDataSetter(Class clazz, String[] hArray, String[] rArray) {
        //this.o=o;
        this.clazz =clazz;
        this.hArray = hArray;
        this.rArray = rArray;
    }
    public Company run() {
        Company com =null;
        Class<?> loadedClass = null;
        try {
            //loadedClass = Class.forName(clazz.getName());
            com = (Company) clazz.newInstance();
            for(int i = 0; i< hArray.length; i++) {

                Method m = clazz.getMethod("set" +capitalizeFirstLetter( hArray[i]), String.class);
                m.invoke(com, rArray[i]);
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
        return com;
    }

    public String capitalizeFirstLetter(String str){
        String ch = str.substring(0,1);
        String remStr= str.substring(1);
        String result= ch.toUpperCase()+remStr;
        return result;
    }
}
