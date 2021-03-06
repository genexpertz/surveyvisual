package com.expertzlab.surveyvi.mapreduce.quitsmoking.place;


import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Created by varsha on 10/4/17.
 */
public class PlaceReducer extends Reducer<Text,Text,Text,Text> {

    public void reduce(Text key,Iterable<Text> values,Context context) throws IOException, InterruptedException {

        int sum = 0;
        for (Text value: values) {
            sum++;
        }
        System.out.println("Sum="+sum);
        context.write(key,new Text(""+sum));
    }
}
