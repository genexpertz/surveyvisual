package com.expertzlab.surveyvi.mapreduce.quitsmoking.place;


import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Created by varsha on 10/4/17.
 */
public class PlaceCombiner<T1, T2, T3, T4> extends Reducer<Text,Text,Text,Text> {

    public void reduce(Text key,Iterable<Text> values,Context context) throws IOException, InterruptedException {

        String place = null;
        boolean smokingFlag = false;

        for (Text value: values) {
            String val = value.toString();
            System.out.println("Values in combiner : "+val);
            StringTokenizer iterator = new StringTokenizer(val,":");
            String partOne = iterator.nextToken();
            if ("place".equals(partOne)){
                place = iterator.nextToken();
            }
            else if ("smoking".equals(partOne)){
                smokingFlag = true;
            }
        }
        if (place != null && smokingFlag == true){
            context.write(new Text(place),new Text("1"));
        }
    }
}
