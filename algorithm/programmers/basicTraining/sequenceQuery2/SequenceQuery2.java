package programmers.basicTraining.sequenceQuery2;

// 수열 구간과 쿼리 2

import utils.Compare;

import java.util.Arrays;

public class SequenceQuery2 {

    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        int max = Arrays.stream(arr).max().getAsInt() + 1;

        for(int i = 0; i < answer.length; i++){
            int value = max;
            for(int j = queries[i][0]; j <= queries[i][1]; j++){
                if((arr[j] > queries[i][2]) && (arr[j] < value)){
                    value = arr[j];
                }
            }
            if(value == max){
                answer[i] = -1;
            }else{
                answer[i] = value;
            }
        }

        return answer;
    }

    public int[] solution2(int[] arr, int[][] queries) {

        int[] answer = new int[queries.length];
        Arrays.fill(answer, -1);

        for (int idx = 0; idx < queries.length; idx++) {
            int[] query = queries[idx];
            int s = query[0], e = query[1], k = query[2];

            for (int i = s; i <= e; i++) {
                if (k < arr[i]) {
                    answer[idx] = answer[idx] == -1 ? arr[i] : Math.min(answer[idx], arr[i]);
                }
            }

        }

        return answer;
    }

    public int[] solution3(int[] arr, int[][] queries){
        int[] answer = new int[queries.length];
        Arrays.fill(answer, Integer.MAX_VALUE);

        for(int i = 0; i < queries.length; i++){
            int s = queries[i][0], e = queries[i][1], k = queries[i][2];

            for(int j = s; j <= e; j++){
                if(arr[j] > k){
                    answer[i] = Math.min(answer[i], arr[i]);
                }
            }

            if(answer[i] == Integer.MAX_VALUE){
                answer[i] = -1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        SequenceQuery2 task = new SequenceQuery2();

        int arr[] = {0, 1, 2, 4, 3};
        int[][] queries = {{0, 4, 2},{0, 3, 2},{0, 2, 2}};

        System.out.println(Arrays.toString(task.solution(arr, queries)));

        Compare.measureTime(()->task.solution(arr, queries), ()->task.solution3(arr, queries));
    }

}
