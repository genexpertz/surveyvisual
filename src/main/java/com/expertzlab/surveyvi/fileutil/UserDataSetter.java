package com.expertzlab.surveyvi.fileutil;

import com.expertzlab.surveyvi.model.QuestionNaire;
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
        Class<?> loadedClass = null;
        try {
        loadedClass = Class.forName(clazz.getName());
        usr = (User) loadedClass.newInstance();
        for(int i = 0; i< hArray.length; i++) {

            if (hArray[i].equals("id")) {
                Method m = clazz.getMethod("set" + capitalizeFirstLetter(hArray[i]), Long.class);
                m.invoke(usr, rArray[i]);
            }
            else if(hArray[i].equals("age")){
                Method m = clazz.getMethod("set" + capitalizeFirstLetter(hArray[i]), int.class);
                m.invoke(usr, rArray[i]);
            }
            else {
                Method m = clazz.getMethod("set" + capitalizeFirstLetter(hArray[i]), String.class);
                m.invoke(usr, rArray[i]);
            }

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
        return usr;
    }

    public String capitalizeFirstLetter(String str){
        String ch = str.substring(0,1);
        String remStr= str.substring(1);
        String result= ch.toUpperCase()+remStr;
        return result;
    }
}
