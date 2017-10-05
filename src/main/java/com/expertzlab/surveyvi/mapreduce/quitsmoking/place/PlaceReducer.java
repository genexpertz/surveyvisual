package com.expertzlab.surveyvi.mapreduce.quitsmoking.place;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class PlaceReducer extends Reducer<Text,Text,Text,Text> {

    protected void reducer(Text key,Iterable<Text> values,Context context) throws IOException, InterruptedException {

        int sum = 0;

        for (Text value:values) {
            sum++;
        }
        System.out.println("key="+key.toString()+"sum="+sum);
        context.write(key,new Text(""+sum));
    }
}
