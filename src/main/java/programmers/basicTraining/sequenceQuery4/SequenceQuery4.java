package programmers.basicTraining.sequenceQuery4;

// 수열과 구간 쿼리 4

import java.util.Arrays;

public class SequenceQuery4 {

    public int[] solution(int[] arr, int[][] queries) {

        for(int i = 0; i < queries.length; i++){
            for(int j = queries[i][0]; j <= queries[i][1]; j++){
                if(j % queries[i][2] == 0){
                    arr[j]++;
                }
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        SequenceQuery4 task = new SequenceQuery4();
        int[] arr = {0, 1, 2, 4, 3};
        int[][] queries = {{0, 4, 1},{0, 3, 2},{0, 3, 3}};

        System.out.println(Arrays.toString(task.solution(arr, queries)));
    }

}
