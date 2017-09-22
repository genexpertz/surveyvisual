package com.expertzlab.surveyvi.mapreduce.quitsmoking;

//import com.expertzlab.surveyvi.mapreduce.quitsmoking.AgeMap;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Created by varsha on 9/21/17.
 */
public class AgeMap extends Mapper<LongWritable,Text,Text,Text> {

   // private Text docId ;
    String filename;
    //private Text age;
    private Text pid;

    public void setup() { setup();}

    @Override
    protected void setup(Context context){
        filename = ((FileSplit)context.getInputSplit()).getPath().toString();
        //docId = new Text(filename);
    }
    @Override
    protected void map(LongWritable key, Text values,Context context) throws IOException, InterruptedException {

        if(filename.contains("\\participant\\")) {
            StringTokenizer iterator = new StringTokenizer(values.toString(), ",");
            pid = new Text(iterator.nextToken());
            iterator.nextToken();
            int age = Integer.parseInt(iterator.nextToken());
            context.write(pid, new Text("age:"+age));
        }
        else if (filename.contains("\\answer\\")){
            StringTokenizer iterator = new StringTokenizer(values.toString(),",");
            iterator.nextToken();
            pid = new Text(iterator.nextToken());
            int qId = Integer.parseInt(iterator.nextToken());
            int optId = Integer.parseInt(iterator.nextToken());

            if(qId == 1 && optId == 1  ){
                context.write(pid,new Text("smoking:1"));
            }
        }
    }



}
