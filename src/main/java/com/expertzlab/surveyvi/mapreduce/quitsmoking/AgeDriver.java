package com.expertzlab.surveyvi.mapreduce.quitsmoking;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 * Created by varsha on 9/21/17.
 */
public class AgeDriver {
    public static void main(String[] args) throws Exception {
        AgeDriver AgeDriver = new AgeDriver();
        Path inp = new Path(args[0]);
        Path out = new Path(args[1]);
        AgeDriver.run(inp,out);
    }

    private void run(Path inp, Path out) throws Exception {

        Configuration conf = new Configuration();
        Job job = new Job(conf);
        job.setJarByClass(AgeDriver.class);
        job.setMapperClass(AgeMap.class);
        job.setCombinerClass(AgeCombiner.class);
        job.setReducerClass(AgeReducer.class);
        job.setMapOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        FileInputFormat.setInputPaths(job,inp);
        FileOutputFormat.setOutputPath(job,out);

        if(job.waitForCompletion(true)){
            System.out.println("Job completed Successfully");
        }
    }
}
