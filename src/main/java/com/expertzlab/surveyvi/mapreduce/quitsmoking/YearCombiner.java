package com.expertzlab.surveyvi.mapreduce.quitsmoking;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;
import java.util.StringTokenizer;


/**
 * Created by avin on 9/26/17.
 */

public class YearCombiner<T1,T2,T3,T4> extends Reducer<Text,Text,Text,Text> {
    public void run(Text key , Iterable<Text> values, Context context) throws IOException, InterruptedException {

        String year = null;
        int count = 0;
        Iterator it = values.iterator();
        while (it.hasNext()){
            count=0;
            year=null;
            StringTokenizer value = new StringTokenizer(it.next().toString(),",");
            while (value.hasMoreTokens()){
                StringTokenizer token = new StringTokenizer(value.nextToken(),":");
                if (token.nextToken().equals("year")){
                    year = token.nextToken();
                    System.out.println("year : "+year);
                }
                else {
                    count++;
                    //System.out.println("count : "+count);
                }
            }

            for (int i=0;i<count;i++){
                System.out.println("Context write : year : "+year+" Smoking : 1");
                context.write(new Text("year:"+year),new Text("smoking:1"));
            }
        }
    }
}
