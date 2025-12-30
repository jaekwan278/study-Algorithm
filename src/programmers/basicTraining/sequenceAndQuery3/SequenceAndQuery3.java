package programmers.basicTraining.sequenceAndQuery3;

// 수열과 구간 쿼리 3

import java.util.Arrays;

public class SequenceAndQuery3 {

    public int[] solution(int[] arr, int[][] queries) {
        int tmp;
        for(int[] query : queries){
            tmp = arr[query[0]];
            arr[query[0]] = arr[query[1]];
            arr[query[1]] = tmp;
        }

        return arr;
    }

    public static void main(String[] args) {
        SequenceAndQuery3 task = new SequenceAndQuery3();
        int[] arr = {0, 1, 2, 3, 4};
        int[][] queries = {{0, 3},{1, 2},{1, 4}};

        System.out.println(Arrays.toString(task.solution(arr, queries)));
    }
}
