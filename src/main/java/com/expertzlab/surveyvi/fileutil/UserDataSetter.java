package com.expertzlab.surveyvi.fileutil;

import com.expertzlab.surveyvi.model.User;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by preethup on 11/8/17.
 */
class UserDataSetter extends DataSetter{

    Class clazz;
    String[] hArray;
    String[] rArray;

    UserDataSetter(Class clazz, String[] hArray, String[] rArray) {
      this.clazz =clazz;
      this.hArray = hArray;
      this.rArray = rArray;
    }
    public User run() {
        User usr =null;
        try {
        usr = (User) clazz.newInstance();
        for(int i = 0; i< hArray.length; i++) {

                Method m = clazz.getMethod("set" + capitalizeFirstLetter(hArray[i]), String.class);
                m.invoke(usr, rArray[i]);


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
        return usr;
    }

    public String capitalizeFirstLetter(String str){
        String ch = str.substring(0,1);
        String remStr= str.substring(1);
        String result= ch.toUpperCase()+remStr;
        return result;
    }
}
