package com.expertzlab.surveyvi.mapreduce.quitsmoking.place;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class BareMap extends Mapper<LongWritable,Text,Text,Text> {
    public void setup(){setup();}

    protected void setup(Context context){
    }

    protected void map(LongWritable key,Text values,Context context) throws IOException, InterruptedException {
        String[] valueArray = values.toString().split("\\t");
        context.write(new Text(valueArray[0]),new Text(valueArray[1]));
    }
}