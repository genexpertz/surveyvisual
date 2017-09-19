package com.expertzlab.surveyvi.fileutil;

import com.expertzlab.surveyvi.model.Question;
import com.expertzlab.surveyvi.model.QuestionNaire;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by preethup on 11/8/17.
 */
class QuestionDataSetter extends DataSetter{

    Class clazz;
    String[] hArray;
    String[] rArray;

    QuestionDataSetter(Class clazz, String[] hArray, String[] rArray) {
      this.clazz =clazz;
      this.hArray = hArray;
      this.rArray = rArray;
    }
    public Question run() {
        Question qus =null;
        String record = null;
        Class<?> loadedClass = null;
        try {
        loadedClass = Class.forName(clazz.getName());
        qus = (Question) loadedClass.newInstance();
        int len =  rArray.length;
        for(int i = 0; i< len; i++) {

            System.out.println("rArraay["+i+"] - "+rArray[i]);
            System.out.println("hArraay["+i+"] - "+hArray[i]);

            Method    m = clazz.getMethod("set" + capitalizeFirstLetter(hArray[i]), String.class);
            m.invoke(qus, rArray[i]);


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
        return qus;
    }

    public String capitalizeFirstLetter(String str){
        String ch = str.substring(0,1);
        String remStr= str.substring(1);
        String result= ch.toUpperCase()+remStr;
        return result;
    }
}
