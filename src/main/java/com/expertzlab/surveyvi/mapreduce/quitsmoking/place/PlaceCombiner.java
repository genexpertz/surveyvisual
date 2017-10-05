package com.expertzlab.surveyvi.mapreduce.quitsmoking.place;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import java.io.IOException;
import java.util.StringTokenizer;

public class PlaceCombiner extends Reducer<Text,Text,Text,Text> {

    protected void reducer(Text key,Iterable<Text> values,Context context) throws IOException, InterruptedException {

        String place = null;
        String attendance = null;
        boolean attendanceFlag = false;

        for (Text value: values) {
            String val = value.toString();
            System.out.println("Values in combiner : "+val);
            StringTokenizer iterator = new StringTokenizer(val,":");
            String partOne = iterator.nextToken();
            if ("place".equals(partOne)){
                place = iterator.nextToken();
            }
            else if ("attendance".equals(partOne)){
                attendanceFlag = true;
            }
        }
        if (place != null && attendanceFlag == true){
            context.write(new Text(place),new Text("1"));
        }
    }
}
