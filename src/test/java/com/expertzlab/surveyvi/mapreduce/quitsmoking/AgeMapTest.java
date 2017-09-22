package com.expertzlab.surveyvi.mapreduce.quitsmoking;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;


import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AgeMapTest{
        AgeMap ageMap;
        Mapper.Context context;
        Text value;
        LongWritable key;

        @Before
        public void setUp() {
            ageMap = new AgeMap();
            context = mock(Mapper.Context.class);
            key = new LongWritable(1000);
            value = new Text("3,Kanu Manu29,40,M,Thrissur");
            FileSplit split = mock(FileSplit.class);
            Path p = new Path("hdfs://localhost:9000/surveytest/participant.txt");
            when(split.getPath()).thenReturn(p);
            when(context.getInputSplit()).thenReturn(split);

            }

        @Test
        public void testMapperForParticipant() throws IOException, InterruptedException {
            ageMap.setup(context);
            ageMap.map(key,value,context);
        }
}
