package com.expertzlab.surveyvi.mapreduce.quitsmoking;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Created by varsha on 9/21/17.
 */
public class AgeCombiner<T, T1, T2, T3> extends Reducer<Text,Text,Text,Text> {


    public void reduce(Text key,Iterable<Text> values,Context context) throws IOException, InterruptedException {

        int age =0;
        String smokingFlag = null;
        String group = null;
        for (Text value : values) {
            String val = value.toString();
            System.out.println("In combiner value="+val);
            StringTokenizer iterator = new StringTokenizer(val,":");
            String partOne = iterator.nextToken();
            if("age".equals(partOne)) {
                age = Integer.parseInt(iterator.nextToken());

                if (age >= 11 && age <= 20) {
                    group = "11-20";
                } else if (age >= 21 && age <= 30) {
                    group = "21-30";
                } else if (age >= 31 && age <= 40) {
                    group = "31-40";
                } else if (age >= 41 && age <= 50) {
                    group = "41-50";
                } else if (age >= 51 && age <= 60) {
                    group = "51-60";
                } else if (age >= 61 && age <= 70) {
                    group = "61-70";
                } else if (age >= 71 && age <= 80) {
                    group = "71-80";
                } else if (age >= 81 && age <= 90) {
                    group = "81-90";
                }

                System.out.println("group =" + group);
            }

        }
        if(group != null) {
            context.write(new Text(group), new Text("1"));
        }
    }
}
