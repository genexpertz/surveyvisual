package com.expertzlab.surveyvi.mapreduce.quitsmoking.gender;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.StringTokenizer;


public class GenderCombiner<T, T1, T2, T3> extends Reducer<Text,Text,Text,Text> {


    public void reduce(Text key,Iterable<Text> values,Context context) throws IOException, InterruptedException {

        int age =0;
        String gender = null;
        String smokingFlag = null;
        String group = null;

        for (Text value : values) {
            String val = value.toString();
            System.out.println("In combiner value="+val);
            StringTokenizer iterator = new StringTokenizer(val,":");
            String partOne = iterator.nextToken();
            if("age".equals(partOne)) {
                age = Integer.parseInt(iterator.nextToken());

                    if (gender == "male") {
                        group = "male";
                    } else{
                        group = "female";
                    }

                    System.out.println("group =" + group);
                }
        }
        if(group != null) {
            context.write(new Text(group), new Text("1"));
        }
    }
}
