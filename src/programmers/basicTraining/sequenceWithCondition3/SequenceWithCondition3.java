package programmers.basicTraining.sequenceWithCondition3;

// 조건에 맞게 수열 반환하기 3

import utils.Compare;

import java.util.Arrays;

public class SequenceWithCondition3 {

    public int[] solution(int[] arr, int k) {

        return (k % 2 == 0)
                ? Arrays.stream(arr).map(n -> n + k).toArray()
                : Arrays.stream(arr).map(n -> n * k).toArray();
    }

    public int[] solution2(int[] arr, int k){

        return Arrays.stream(arr).map(n -> (k % 2 == 0) ? n + k : n * k).toArray();
    }

    public static void main(String[] args) {
        SequenceWithCondition3 task = new SequenceWithCondition3();
        int[] arr = {1, 2, 3, 100, 99, 98};
        int k = 3;

        System.out.println(Arrays.toString(task.solution(arr, k)));

        Compare.measureTime(()-> task.solution(arr, k), ()-> task.solution2(arr, k));
    }

}
