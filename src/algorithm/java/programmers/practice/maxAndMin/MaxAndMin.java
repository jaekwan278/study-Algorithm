package programmers.practice.maxAndMin;

// 최댓값과 최솟값

import utils.Compare;

import java.util.Arrays;
import java.util.IntSummaryStatistics;

public class MaxAndMin {

    public String solution(String s) {
        int[] arr = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

        return arr[0] + " " + arr[arr.length-1];
    }
    public String solution2(String s) {
        IntSummaryStatistics stats = Arrays.stream(s.split(" "))
                .mapToInt(Integer::parseInt)
                .summaryStatistics();

        return stats.getMin() + " " + stats.getMax();
    }
    public String solution3(String s) {
        String[] tokens = s.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(String str : tokens){
            int num = Integer.parseInt(str);
            if(num < min) min = num;
            if(num > max) max = num;
        }

        return min + " " + max;
    }

    public static void main(String[] args) {
        MaxAndMin task = new MaxAndMin();
        String s = "-1 -2 -3 -4";

        System.out.println(task.solution(s));

        Compare.measureTime(()->task.solution(s), ()->task.solution3(s));
    }
}
