package com.expertzlab.surveyvi.mapreduce.quitsmoking.year;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Created by avin on 9/26/17.
 */


public class YearReducer extends Reducer<Text,Text,Text,Text> {

    public void reduce(Text key,Iterable<Text> values,Context context) throws IOException, InterruptedException {
        int sum = 0;
        Text yearText = new Text();
        String year = null;
        for (Text value : values){
            String[] kevValue = value.toString().split(":");
            if("year".equals(kevValue[0])){
                year = kevValue[1];
            } else if("smoking".equals(kevValue[0])) {
                sum++;
            }
        }
        yearText.set(year);
        context.write(yearText,new Text(""+sum));
    }
}
