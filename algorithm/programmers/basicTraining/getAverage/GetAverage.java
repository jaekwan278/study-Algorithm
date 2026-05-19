package programmers.basicTraining.getAverage;

// 평균 구하기

import utils.Compare;

import java.util.Arrays;

public class GetAverage {

    public double solution(int[] arr) {
        return (double) Arrays.stream(arr).sum() / arr.length;
    }

    public double solution2(int[] arr){
        double sum = 0;
        for(int n : arr){
            sum += n;
        }

        return sum / arr.length;
    }

    public double solution3(int[] arr){
        return Arrays.stream(arr).average().orElse(0);
    }

    public static void main(String[] args) {
        GetAverage task = new GetAverage();
        int[] arr = {1,2,-3,4};

        System.out.println(task.solution2(arr));

        Compare.measureTime(()->task.solution(arr), ()->task.solution3(arr));
    }

}
