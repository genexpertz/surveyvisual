package com.expertzlab.surveyvi.mapreduce.quitsmoking.gender;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class GenderDriver {
    public static void main(String[] args) throws Exception {
        GenderDriver GenderDriver = new GenderDriver();
        Path inp = new Path(args[0]);
        Path out = new Path(args[1]);
        GenderDriver.run(inp,out);
    }

    public void run(Path inp,Path out) throws Exception {
        Configuration conf = new Configuration();
        Job job = new Job(conf);
        job.setJarByClass(GenderDriver.class);
        job.setMapperClass(GenderMap.class);
        job.setReducerClass(GenderCombiner.class);
        job.setMapOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        FileInputFormat.setInputPaths(job,inp);
        Path tempGender = new Path("/surveyoutput/tempgender"+System.currentTimeMillis());
        FileOutputFormat.setOutputPath(job,tempGender);

        if(job.waitForCompletion(true)){
            System.out.println("Job 1 completed Successfully");
        }

        job = new Job(conf);
        job.setJarByClass(GenderDriver.class);
        job.setMapperClass(BareMap.class);
        job.setReducerClass(GenderReducer.class);
        job.setMapOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        FileInputFormat.setInputPaths(job,tempGender);
        FileOutputFormat.setOutputPath(job,out);

        if (job.waitForCompletion(true)){
            System.out.println("Job 2 completed Successfully");
        }
    }
}
