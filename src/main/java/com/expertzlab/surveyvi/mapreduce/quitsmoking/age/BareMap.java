package com.expertzlab.surveyvi.mapreduce.quitsmoking.age;

/**
 * Created by preethup on 27/9/17.
 */

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;



public class BareMap extends Mapper<LongWritable,Text,Text,Text> {


    public void setup() { setup();}

    @Override
    protected void setup(Context context){

    }
    @Override
    protected void map(LongWritable key, Text value,Context context) throws IOException, InterruptedException {
        String[] valueArray = value.toString().split("\\t");

       context.write(new Text(valueArray[0]),new Text(valueArray[1]));
    }



}

