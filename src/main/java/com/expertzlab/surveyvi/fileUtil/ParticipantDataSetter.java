package com.expertzlab.surveyvi.fileUtil;

import com.expertzlab.surveyvi.model.Participant;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by preethup on 11/8/17.
 */
class ParticipantDataSetter extends DataSetter {

    Class clazz;
    String[] hArray;
    String[] rArray;
    ParticipantDataSetter(Class clazz, String[] hArray, String[] rArray) {
      //this.o=o;
      this.clazz =clazz;
      this.hArray = hArray;
      this.rArray = rArray;
    }
    public void run() {
        Participant pt =null;
        for(int i = 0; i< hArray.length; i++) {
            Class<?> loadedClass = null;
            try {
                loadedClass = Class.forName(clazz.getName());
            pt = (Participant) loadedClass.newInstance();
            Method m = clazz.getMethod("set" + hArray[i], String.class);
            m.invoke(pt, rArray[i]);
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
        }

    }
}
