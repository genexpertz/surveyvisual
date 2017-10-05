package com.expertzlab.surveyvi.mapreduce.quitsmoking.place;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * Created by varsha on 10/4/17.
 */
public class BareMap extends Mapper<LongWritable,Text,Text,Text> {
    public void setup(){setup();}

    protected void setup(Context context){
    }

    protected void map(LongWritable key,Text values,Context context) throws IOException, InterruptedException {
        String val = values.toString();

        System.out.println("Values in BareMap = "+val);

        String[] valueArray = values.toString().split("\\t");
        context.write(new Text(valueArray[0]),new Text(valueArray[1]));
    }
}
