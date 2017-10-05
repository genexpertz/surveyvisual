package com.expertzlab.surveyvi.mapreduce.quitsmoking.gender;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * Created by varsha on 10/5/17.
 */
public class BareMap extends Mapper<LongWritable,Text,Text,Text> {

    protected void map(LongWritable key,Text values,Context context) throws IOException, InterruptedException {
        String[] arrayValues = values.toString().split("\\t");
        context.write(new Text(arrayValues[0]),new Text(arrayValues[1]));
    }
}
