package com.expertzlab.surveyvi.mapreduce.quitsmoking.gender;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.StringTokenizer;


public class GenderCombiner<T, T1, T2, T3> extends Reducer<Text,Text,Text,Text> {


    public void reduce(Text key,Iterable<Text> values,Context context) throws IOException, InterruptedException {
        boolean smokingFlag = false;
        String gender = null;

        for (Text value: values) {
            String val = value.toString();
            System.out.println("Values in combiner : "+val);
            StringTokenizer iterator = new StringTokenizer(val,":");
            String partOne = iterator.nextToken();
            if ("gender".equals(partOne)){
               gender = iterator.nextToken();
            }
            else if ("smoking".equals(partOne)){
                smokingFlag = true;
            }
        }
        if (gender != null && smokingFlag == true){
            System.out.println(gender+"1");
            context.write(new Text(gender),new Text("1"));
        }
    }
}
