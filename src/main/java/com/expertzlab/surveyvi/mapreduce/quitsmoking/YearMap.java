package com.expertzlab.surveyvi.mapreduce.quitsmoking;


import org.apache.hadoop.io.LongWritable;


import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;
import java.io.IOException;
import java.util.StringTokenizer;


public class    YearMap extends Mapper<LongWritable,Text,Text,Text> {


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


        if (filename.contains("/event")){
            StringTokenizer iterator = new StringTokenizer(value,",");
            eventId = iterator.nextToken();
            iterator.nextToken();
            iterator.nextToken();
            date = iterator.nextToken();
            String[] date1 = date.split("/");
            String year = date1[2];
            context.write(new Text(eventId),new Text("year:"+year));

        }else if (filename.contains("/answer")){

            String[] answerTable = value.split(",");
            int qId = Integer.parseInt(answerTable[3]);
            int optionId = Integer.parseInt(answerTable[4]);
            String eventId = answerTable[5];

            if(qId == 1 && optionId == 1){
                context.write(new Text(eventId),new Text("smoking:"+1));
            }

        }
    }
}
