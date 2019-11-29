package com.geng;


import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;

/**
 * Created by GengYongJiang on 2017/6/12.
 */
public class Main {
    public enum PowerType{
        LOGIN("login",0),
        QUEST("quest",1),
        PLAYER("player",2),
        TALENT("talent",3),
        HERO("hero",4),
        ARMY("army",5),
        BUILDING("building",6),
        SCIENCE("science",7),
        FORT("fort",8),
        EQUIP("equip",9),
        DRAGON("dragon",10);

        String name;
        int value;

        PowerType(String name,int value){
            this.name = name;
            this.value = value;
        }

        String getName(){return name;}
        int getValue(){return value;}
    }

    public static void main(String[] args){
        ReentrantLock lock = new ReentrantLock();
            System.out.println(lock.getClass().getName());
        System.out.println(lock.getClass().getSimpleName());
        System.out.println(ReentrantLock.class);
    }
    public static void main1(String[] args){

        String item = "::200006:1::";
        String item1 = "boo:and:foo";
        String[] itemArr = item.split(":");


        System.out.println("hello!!");
        /**
         * lamda 表达式 在集合上的应用 stream方法
         */
        List<String> collected = new ArrayList<>();
 //值转换值 map
        collected  = Stream.of("a","b","c").map(value -> value.toUpperCase()).collect(toList());

        System.out.println(collected);
//过滤filer
        collected  = Stream.of("a","b","ac").filter(value -> !value.contains("a")).collect(toList());
        System.out.println(collected);

//值转换为流 flatMap   合并多个集合的例子
        collected = Stream.of(asList(1,2),asList(3,4)).flatMap(n -> n.stream().map(i -> String.valueOf(i))).collect(toList());
        System.out.println("_____"+collected);

        //使用收集器 1.toCollection  至于toList，toSet也同样 2.maxBy minBy 3.patitioningBy 4.groupingBy(Stram,function) 5.连接字符串  Collectors.joining(sep,prefix,sufix)




    }
}

//
//import java.text.SimpleDateFormat;
//import java.util.*;
//import java.util.concurrent.Executor;
//import java.util.stream.StreamSupport;
//
//public class Main {
//    /**
//     * --------mapSideLen=3601 MAX_WORLD_POINT=12967201 areaSideLen=60
//     -------------areaCountPerRow=61 maxAreaCount=3721 areaSideLen={}
//     -------------areaCountPerRow2=61 maxAreaCount2=3721 areaSideLen={}
//     */
//    private static final int MAP_ROW = 3601;
//    private static final int BORN_AREA_SIDE = 60;
//
//    public static void main(String[] args) {
//        int start = 883683;
//        for(int pointId =start;pointId > start -10;pointId--) {
////            int pointId = 12967201;
//            int xy[] = getXY(pointId, MAP_ROW);
////            int areaId = calcAreaIdFromPointId(pointId);
////            System.out.println("pointId=" + pointId + " x=" + xy[0] + " y=" + xy[1] + " areaId=" + areaId);
//        }
//    }
//
//    public static void concurrentTest(){
//        Thread t = new Thread();
//        Executor e= new Executor() {
//            @Override
//            public void execute(Runnable command) {
//                command.run();
//            }
//        };
//        e.execute(t);
//
////lamda?
////        e->execute(t);
//    }
//    public static int[] getXY(int pointId, int worldRow){
//        pointId -= 1;
//        int y = pointId / worldRow;
//        int x = pointId % worldRow;
//        return new int[]{x, y};
//    }
//
////    public static int calcAreaIdFromPointId(int pointId){
////        int[] XY = getXY(pointId, MAP_ROW);
////        final int areaSideLen = BORN_AREA_SIDE, mapSideLen = MAP_ROW;
////        int x=XY[0];
////        int y=XY[1];
////
////        int row = x/areaSideLen;
////        int column = y/areaSideLen+1;
////        Collection<String> test= new HashSet<>();
////        test.stream().filter(e->e.getColor()==Collor.Red).a;
////        Stream<E> s = StreamSupport.stream(() -> spliterator(), spliteratorCharacteristics);
////        final int areaCountPerRow = mapSideLen%areaSideLen==0 ? mapSideLen/areaSideLen :  mapSideLen/areaSideLen+1 ;
////        final int maxAreaCount = (int) Math.pow(areaCountPerRow, 2.0);
////        int areaId = (column-1)*areaCountPerRow+row+1;
////        areaId = areaId > maxAreaCount? maxAreaCount : areaId;
////        areaId = areaId < 1 ? 1:areaId;
////        return areaId;
////    }
////}
//
////public class SimpleThreads {
//
//    // Display a message, preceded by
//    // the name of the current thread
////    static void threadMessage(String message) {
////        String threadName =
////                Thread.currentThread().getName();
////        System.out.format("%s: %s%n",
////                threadName,
////                message);
////    }
//
////    private static class MessageLoop
////            implements Runnable {
////        public void run() {
////            String importantInfo[] = {
////                    "Mares eat oats",
////                    "Does eat oats",
////                    "Little lambs eat ivy",
////                    "A kid will eat ivy too"
////            };
////            try {
////                for (int i = 0;
////                     i < importantInfo.length;
////                     i++) {
////                    // Pause for 4 seconds
////                    Thread.sleep(4000);
////                    // Print a message
////                    threadMessage(importantInfo[i]);
////                }
////            } catch (InterruptedException e) {
////                threadMessage("I wasn't done!");
////            }
////        }
////    }
//
//    public static void main(String args[])
//            throws InterruptedException {
//
////        // Delay, in milliseconds before
////        // we interrupt MessageLoop
////        // thread (default one hour).
////        long patience = 1000 * 60 * 60;
////
////        // If command line argument
////        // present, gives patience
////        // in seconds.
////        if (args.length > 0) {
////            try {
////                patience = Long.parseLong(args[0]) * 1000;
////            } catch (NumberFormatException e) {
////                System.err.println("Argument must be an integer.");
////                System.exit(1);
////            }
////        }
//
////        threadMessage("Starting MessageLoop thread");
////        long startTime = System.currentTimeMillis();
////        Thread t = new Thread(new MessageLoop());
////        t.start();
////
////        threadMessage("Waiting for MessageLoop thread to finish");
////        // loop until MessageLoop
////        // thread exits
////        while (t.isAlive()) {
////            threadMessage("Still waiting...");
////            // Wait maximum of 1 second
////            // for MessageLoop thread
////            // to finish.
////            t.join(1000);
////            if (((System.currentTimeMillis() - startTime) > patience)
////                    && t.isAlive()) {
////                threadMessage("Tired of waiting!");
////                t.interrupt();
////                // Shouldn't be long now
////                // -- wait indefinitely
////                t.join();
////            }
////        }
////        threadMessage("Finally!");
//    }
//}
