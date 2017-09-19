package com.expertzlab.surveyvi.mapreduce.quitsmoking;

import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.util.StringUtils;

/**
 * Created by avin on 17/9/17.
 */
public class AgeGroupMap extends Mapper<LongWritable, Text, Text,Text> {

        private Text documentId;
        private Text word = new Text();

        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            for(String token: StringUtils.split(value.toString(),' ')){
                word.set(token);
                context.write(word, new Text("1"));
                System.out.println("word:"+word.toString()+", docid:"+documentId);
            }
        }
    }
