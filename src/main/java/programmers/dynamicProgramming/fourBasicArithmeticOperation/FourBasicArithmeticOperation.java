package programmers.dynamicProgramming.fourBasicArithmeticOperation;

// 사칙 연산

/*

    0. 부호, 숫자 구분 -> nums[], signs[]

    1. 범위 기준 반복 (길이)
        2.

 */

import java.util.Arrays;

public class FourBasicArithmeticOperation {

    public int solution(String arr[]) {

        int[] nums = new int[arr.length / 2 + 1];
        char[] signs = new char[arr.length / 2];

        for(int i = 0; i < arr.length; i++){
            if(i % 2 == 0) nums[i / 2] = Integer.parseInt(arr[i]);
            else signs[i / 2] = arr[i].charAt(0);
        }


        int n = nums.length;
        int[][] maxDp = new int[n][n];
        int[][] minDp = new int[n][n];

        for(int i = 0; i < n; i++){
            maxDp[i][i] = minDp[i][i] = nums[i];
        }


        for(int len = 1; len < n; len++){

            for(int i = 0; i + len < n; i++){
                int j = i + len;

                maxDp[i][j] = Integer.MIN_VALUE;
                minDp[i][j] = Integer.MAX_VALUE;

                for(int k = i; k < j; k++){
                    char sign = signs[k];

                    if(sign == '+'){

                        maxDp[i][j] = Math.max(maxDp[i][k] + maxDp[k+1][j], maxDp[i][j]);
                        minDp[i][j] = Math.min(minDp[i][k] + minDp[k+1][j], minDp[i][j]);

                    }else{

                        maxDp[i][j] = Math.max(maxDp[i][k] - minDp[k+1][j], maxDp[i][j]);
                        minDp[i][j] = Math.min(minDp[i][k] - maxDp[k+1][j], minDp[i][j]);

                    }
                }

            }

        }

        return maxDp[0][n-1];
    }

    public static void main(String[] args) {
        FourBasicArithmeticOperation task = new FourBasicArithmeticOperation();
        String[] arr = {"5", "-", "3", "+", "1", "+", "2", "-", "4"};

        System.out.println(task.solution(arr));
    }

}

/*
       0  1  2
     0 [] [] []
     1 [] [] []
     2 [] [] []

 */


// 1 - 3 + 5 - 8