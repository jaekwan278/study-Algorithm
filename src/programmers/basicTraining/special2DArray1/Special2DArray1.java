package programmers.basicTraining.special2DArray1;

// 특별한 이차원 배열 1

import java.util.Arrays;

public class Special2DArray1 {

    public int[][] solution(int n) {
        int[][] answer = new int[n][n];

        for(int i = 0; i < n; i++){
            answer[i][i] = 1;
        }

        return answer;
    }

    public static void main(String[] args) {
        Special2DArray1 task = new Special2DArray1();
        int n = 3;

        for(int[] a : task.solution(n)){
            System.out.println(Arrays.toString(a));
        }
    }

}
