package com.expertzlab.surveyvi.mapreduce.quitsmoking;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class AgeGroupDriver {

        public static void main(String[] args) throws Exception {
            AgeGroupDriver riDriver = new AgeGroupDriver();
            Path inp = new Path(args[0]);
            Path outp = new Path(args[1]);
            riDriver.run(inp, outp);

        }

        public void run(Path inp, Path outp) throws Exception {


            Configuration conf = new Configuration();
            Job job = new Job(conf);
            job.setJarByClass(AgeGroupDriver.class);
            job.setMapperClass(AgeGroupMap.class);
            job.setReducerClass(AgeGroupReduce.class);
            job.setMapOutputKeyClass(Text.class);
            job.setMapOutputValueClass(Text.class);

            FileInputFormat.setInputPaths(job,inp);

            FileOutputFormat.setOutputPath(job,outp);

            if(job.waitForCompletion(true)){
                System.out.println("Job Completed Successfully");
            }
        }
    }

