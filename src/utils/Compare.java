package utils;

public class Compare {
    // 속도 비교
    public static void measureTime(Runnable taskA, Runnable taskB){

        // taskA 소요 시간
        long startTimeA = System.nanoTime();
        taskA.run();
        long endTimeA = System.nanoTime();

        long durA = endTimeA - startTimeA;

        // taskB 소요시간
        long startTimeB = System.nanoTime();
        taskB.run();;
        long endTimeB = System.nanoTime();

        long durB = endTimeB - startTimeB;

        long diff = durA - durB;

        System.out.println("A가 B보다 " + Math.abs(diff) + "(ns) " + ((diff > 0) ? "더 느림" : "더 빠름"));

    }
}
