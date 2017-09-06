package com.expertzlab.surveyvi.fileutil;

import com.expertzlab.surveyvi.model.QuestionNaire;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by preethup on 11/8/17.
 */
class QuestionNaireDataSetter extends DataSetter{

    Class clazz;
    String[] hArray;
    String[] rArray;

    QuestionNaireDataSetter(Class clazz, String[] hArray, String[] rArray) {
      this.clazz =clazz;
      this.hArray = hArray;
      this.rArray = rArray;
    }
    public QuestionNaire run() {
        QuestionNaire qusnaire =null;
        Class<?> loadedClass = null;
        try {
        loadedClass = Class.forName(clazz.getName());
        qusnaire = (QuestionNaire) loadedClass.newInstance();
        for(int i = 0; i< hArray.length; i++) {

            Method m = clazz.getMethod("set" +capitalizeFirstLetter( hArray[i]), String.class);
            m.invoke(qusnaire, rArray[i]);
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
        return qusnaire;
    }

    public String capitalizeFirstLetter(String str){
        String ch = str.substring(0,1);
        String remStr= str.substring(1);
        String result= ch.toUpperCase()+remStr;
        return result;
    }
}
