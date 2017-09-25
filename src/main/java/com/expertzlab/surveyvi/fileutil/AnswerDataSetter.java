package com.expertzlab.surveyvi.fileutil;

import com.expertzlab.surveyvi.model.Answer;
import com.expertzlab.surveyvi.model.QuestionNaire;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by preethup on 11/8/17.
 */
class AnswerDataSetter extends DataSetter{

    Class clazz;
    String[] hArray;
    String[] rArray;

    AnswerDataSetter(Class clazz, String[] hArray, String[] rArray) {
      this.clazz =clazz;
      this.hArray = hArray;
      this.rArray = rArray;
    }
    public Answer run() {
        Answer ans =null;
        try {
        ans = (Answer) clazz.newInstance();
        for(int i = 0; i< rArray.length; i++) {


                Method m = clazz.getMethod("set" + capitalizeFirstLetter(hArray[i]), String.class);
                m.invoke(ans, rArray[i]);

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
        return ans;
    }

    public String capitalizeFirstLetter(String str){
        String ch = str.substring(0,1);
        String remStr= str.substring(1);
        String result= ch.toUpperCase()+remStr;
        return result;
    }
}
