package com.expertzlab.surveyvi.fileutil;

import com.expertzlab.surveyvi.model.Options;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by preethup on 25/8/17.
 */
public class OptionDataSetter extends DataSetter{
    Class clazz;
    String[] hArray;
    String[] rArray;

    OptionDataSetter(Class clazz, String[] hArray, String[] rArray) {
        this.clazz =clazz;
        this.hArray = hArray;
        this.rArray = rArray;
    }
    public Options run() {
        Options op =null;
        Class<?> loadedClass = null;
        try {
            //loadedClass = Class.forName(clazz.getName());
            op = (Options) clazz.newInstance();
            for(int i = 0; i< hArray.length; i++) {

                if (hArray[0].equals("id")) {
                    Method m = clazz.getMethod("set" + capitalizeFirstLetter(hArray[i]), Long.class);
                    m.invoke(op, rArray[i]);
                }
                else {
                    Method m = clazz.getMethod("set" + capitalizeFirstLetter(hArray[i]), String.class);
                    m.invoke(op, rArray[i]);
                }

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
        return op;
    }

    public String capitalizeFirstLetter(String str){
        String ch = str.substring(0,1);
        String remStr= str.substring(1);
        String result= ch.toUpperCase()+remStr;
        return result;
    }
}
