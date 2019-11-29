package com.geng;

import java.util.stream.IntStream;

/**
 * @author GengYongjiang on 29/11/2019
 */
public class StreamTest {
    public static void main(String argvs[]){
        StreamTest t = new StreamTest();
        t.testIntStream();

    }

    public void testIntStream(){
        IntStream odds = IntStream.rangeClosed(0,30).filter(n -> n %2 == 1);
        odds.forEach(n -> System.out.println(n + "\n"));
    }
}
