package com.expertzlab.surveyvi.mapreduce.quitsmoking;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

import java.util.StringTokenizer;
/**
 * Created by avin on 9/26/17.
 */
public class GenderMap extends Mapper<LongWritable,Text,Text,Text> {
    String filename;

    protected Text evid;

    public void setup() { setup();}

    @Override
    protected void setup(Context context){
        filename = ((FileSplit)context.getInputSplit()).getPath().toString();
    }

    @Override
    protected void map(LongWritable key, Text values,Context context){
        System.out.println("File Name="+filename);
        String value = values.toString();
        System.out.println("Value string"+ value);

        if(filename.contains("/event")) {
            StringTokenizer iterator = new StringTokenizer(value, ",");
            evid = new Text(iterator.nextToken());

        }
    }
}


