package com.expertzlab.surveyvi.mapreduce.quitsmoking.gender;

//import com.expertzlab.surveyvi.mapreduce.quitsmoking.age.AgeMap;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

import java.io.IOException;
import java.util.StringTokenizer;


public class GenderMap extends Mapper<LongWritable,Text,Text,Text> {

    // private Text docId ;
    String filename;

    protected String pid;
    protected String gender;

    public void setup() { setup();}

    @Override
    protected void setup(Context context){
        filename = ((FileSplit)context.getInputSplit()).getPath().toString();
    }

    @Override
    protected void map(LongWritable key, Text values,Context context) throws IOException, InterruptedException {

        System.out.println("File Name="+filename);
        String value = values.toString();
        System.out.println("Value string = "+ value);

        if(filename.contains("/participant")) {
            StringTokenizer iterator = new StringTokenizer(value, ",");
            pid = iterator.nextToken();
            iterator.nextToken();
            iterator.nextToken();
            gender = iterator.nextToken();
            context.write(new Text(pid), new Text("gender:"+gender));
            System.out.println("Wrote:"+pid+",gender:"+gender);
        }
        else if (filename.contains("/answer")){
            StringTokenizer iterator = new StringTokenizer(values.toString(),",");
            iterator.nextToken();
            pid = iterator.nextToken();
            int qId = Integer.parseInt(iterator.nextToken());
            int optId = Integer.parseInt(iterator.nextToken());

            if(qId == 1 && optId == 1 ){
                context.write(new Text(pid),new Text("smoking:1"));
                System.out.println("wrote:"+pid+",smoking:1");
            }
        }
    }

}

