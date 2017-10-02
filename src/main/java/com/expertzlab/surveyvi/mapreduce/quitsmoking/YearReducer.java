package com.expertzlab.surveyvi.mapreduce.quitsmoking;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Created by avin on 9/26/17.
 */


public class YearReducer extends Reducer<Text,Text,Text,Text> {

    public void reduce(Text key,Iterable<Text> values,Context context) throws IOException, InterruptedException {
        int sum = 0;
        for (Text value : values){
            sum++;
        }
        context.write(key,new Text("sum:1"));
    }
}
