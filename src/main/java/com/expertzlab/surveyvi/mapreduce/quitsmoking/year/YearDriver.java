package com.expertzlab.surveyvi.mapreduce.quitsmoking.year;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 * Created by avin on 9/23/17.
 */
public class YearDriver {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        YearDriver yearDriver = new YearDriver();
        Path inp = new Path(args[0]);
        Path out = new Path(args[1]);
        yearDriver.run(inp,out);
    }

    private void run(Path inp, Path out) throws IOException, ClassNotFoundException, InterruptedException {

        Configuration conf = new Configuration();
        Job job = new Job(conf);
        job.setJarByClass(YearDriver.class);
        job.setMapperClass(YearMap.class);
        job.setCombinerClass(YearCombiner.class);
        job.setReducerClass(YearReducer.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);

        FileInputFormat.setInputPaths(job,inp);
        FileOutputFormat.setOutputPath(job,out);

        if (job.waitForCompletion(true)){
            System.out.println("Job completed successfully");
        }

    }
}
