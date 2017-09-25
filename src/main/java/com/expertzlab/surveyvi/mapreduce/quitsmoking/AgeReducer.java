package com.expertzlab.surveyvi.mapreduce.quitsmoking;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Created by varsha on 9/21/17.
 */
public class AgeReducer extends Reducer<Text,Text,Text,Text> {

    public void reduce(Text key,Iterable<Text> values,Context context) throws IOException, InterruptedException {

        int sum = 0;
        for(Text val : values) {
            sum++;
        }
        System.out.println("sum="+sum);
        context.write(key,new Text(""+sum));
    }
}