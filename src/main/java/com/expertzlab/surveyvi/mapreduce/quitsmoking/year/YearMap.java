package com.expertzlab.surveyvi.mapreduce.quitsmoking.year;

import org.apache.hadoop.io.LongWritable;


import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;
import java.io.IOException;
import java.util.StringTokenizer;



public class YearMap extends Mapper<LongWritable,Text,Text,Text> {

    String filename = null;
    String eventId = null;
    String date = null;

    public void setup() { setup();}

    protected void setup(Context context){
        filename = ((FileSplit)context.getInputSplit()).getPath().toString();
    }

    protected void map(LongWritable key,Text values,Context context) throws IOException, InterruptedException {

        System.out.println("File name : " + filename);
        String value = values.toString();
        System.out.println("String Values : " + value);

        int qId = 0;
        int optionId =0;
        int year = 0;

        if (filename.contains("/answer_view")){
            StringTokenizer iterator = new StringTokenizer(value,",");
            iterator.nextToken();
            iterator.nextToken();
            qId = Integer.parseInt(iterator.nextToken());
            optionId = Integer.parseInt(iterator.nextToken());
            iterator.nextToken();
            iterator.nextToken();
            iterator.nextToken();
            year = Integer.parseInt(iterator.nextToken());

            if(qId == 1 && optionId == 1){
                context.write(new Text(""+year),new Text(""+1));
            }

        }
    }
}
