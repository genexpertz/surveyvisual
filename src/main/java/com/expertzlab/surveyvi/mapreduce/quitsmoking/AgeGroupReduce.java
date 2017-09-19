package com.expertzlab.surveyvi.mapreduce.quitsmoking;

import com.sun.xml.internal.bind.CycleRecoverable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Text;

public class AgeGroupReduce extends Reducer<Text, Text, Text, Text> {

        public void reduce(Text key, Iterable<Text> values, CycleRecoverable.Context context) throws IOException, InterruptedException {
            System.out.println("key:"+key+", values:"+values);

            int sum = 0;
            for(Text docId: values){
                sum++;
            }
            context.write(key,new Text(""+sum));
        }
    }
