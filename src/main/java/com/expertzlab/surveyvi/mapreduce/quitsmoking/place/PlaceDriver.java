package com.expertzlab.surveyvi.mapreduce.quitsmoking.place;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 * Created by varsha on 10/4/17.
 */
public class PlaceDriver  {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        PlaceDriver placeDriver = new PlaceDriver();
        Path inp = new Path(args[0]);
        Path out = new Path(args[1]);
        placeDriver.run(inp,out);
    }

    private void run(Path inp, Path out) throws IOException, ClassNotFoundException, InterruptedException {

        Configuration conf = new Configuration();
        Job job = new Job(conf);
        job.setJarByClass(PlaceDriver.class);
        job.setMapperClass(PlaceMap.class);
        job.setReducerClass(PlaceCombiner.class);
        job.setMapOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        FileInputFormat.setInputPaths(job,inp);
        Path tempPlace = new Path("/surveyoutput/tempplace"+System.currentTimeMillis());
        FileOutputFormat.setOutputPath(job,tempPlace);

        if (job.waitForCompletion(true)){
            System.out.println("Job 1 completed Successfully");
        }

        job = new Job(conf);
        job.setJarByClass(PlaceDriver.class);
        job.setMapperClass(BareMap.class);
        job.setReducerClass(PlaceReducer.class);
        job.setMapOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        FileInputFormat.setInputPaths(job,tempPlace);
        FileOutputFormat.setOutputPath(job,out);

        if (job.waitForCompletion(true)){
            System.out.println("Job 2 completed Successfully");
        }

    }

}
