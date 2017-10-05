package com.expertzlab.surveyvi.mapreduce.quitsmoking.place;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

import java.io.IOException;
import java.util.StringTokenizer;

public class PlaceMap extends Mapper<LongWritable,Text,Text,Text> {

    String filename = null;
    String pid = null;
    String place = null;
    String attendance = null;

    public void setup(){ setup(); }

    protected void setup(Context context){
        filename = ((FileSplit)context.getInputSplit()).getPath().toString();
    }

    protected void map(LongWritable key,Text values,Context context) throws IOException, InterruptedException {

        System.out.println("File Name : "+filename);
        String value = values.toString();
        System.out.println("String Value : "+value);

        if (filename.contains("/participant")){
            StringTokenizer iterator = new StringTokenizer(value,",");
            pid = iterator.nextToken();
            iterator.nextToken();
            iterator.nextToken();
            iterator.nextToken();
            place = iterator.nextToken();

            System.out.println("Wrote:"+pid+"place:"+place);
            context.write(new Text(pid),new Text("place:"+place));
        }
        else if (filename.contains("/attendance")){
            StringTokenizer iterator = new StringTokenizer(value,",");
            pid = iterator.nextToken();
            iterator.nextToken();
            attendance = iterator.nextToken();
            if (attendance.equals("yes")){
                System.out.println("Wrote:"+pid+"place"+attendance);
                context.write(new Text(pid),new Text("attendance:"+attendance));
            }
        }
    }

}