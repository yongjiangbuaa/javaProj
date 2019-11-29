package com.geng;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author GengYongjiang on 29/11/2019
 */
public class StreamTest {
    public static void main(String argvs[]){
        StreamTest t = new StreamTest();
        t.fibonacci();
//        t.iterateFileLine();

    }

    public void testIntStream(){
        IntStream odds = IntStream.rangeClosed(0,30).filter(n -> n %2 == 1);
        odds.forEach(n -> System.out.println(n ));
    }
    public void iterateFileLine(){
        try {
            long count =Files.lines(Paths.get("/tmp/StreamTest.java"),Charset.defaultCharset()).count();
            System.out.println("count="+count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fibonacci(){
        Stream.iterate(1,n -> n*n+1).limit(3).forEach(n->System.out.println(n));
    }
}
