package programmers.monthlyChallenge.countingQuadsAfterCompression;

// 쿼드압축 후 개수 세기

import java.util.Arrays;

public class CountingQuadsAfterCompression {

    /// try 1
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];

        int len = arr.length;
        int range = arr.length / 2;

        while(range >= 1){

            for(int i = 0; i < len; i += range){
                for(int j = 0; j < len; j += range){
                    int target = arr[i][j];

                    if(target == 2){
                        fill(i, j, (range / 2), arr);
                        continue;
                    }

                    if(isSame(i, (i + range), j, (j + range), target, arr)){
                        fill(i, j, (range / 2), arr);
                        answer[target]++;
                    }
                }
            }

            range /= 2;
        }

        return answer;
    }
    private void fill(int row, int col, int offset, int[][] arr){
        arr[row][col] = 2;
        arr[row][col + offset] = 2;
        arr[row + offset][col] = 2;
        arr[row + offset][col + offset] = 2;
    }
    private boolean isSame(int rowBegin, int rowEnd, int colBegin, int colEnd, int target, int[][] arr){
        for(int i = rowBegin; i < rowEnd; i++){
            for(int j = colBegin; j < colEnd; j++){

                if(arr[i][j] != target) return false;

            }
        }

        return true;
    }

    /// try 2
    public int[] solution2(int[][] arr) {
        int[] answer = new int[2];
        int range = arr.length;

        recursion(arr, 0, 0, range, answer);

        return answer;
    }

    private void recursion(int[][] arr, int row, int col, int range, int[] result){

        int target = arr[row][col];

        for(int i = row; i < (row + range); i++){
            for(int j = col; j < (col + range); j++){

                if(arr[i][j] != target){
                    int half = range / 2;

                    recursion(arr, row, col, half, result);
                    recursion(arr, (row + half), col, half, result);
                    recursion(arr, row, (col + half), half, result);
                    recursion(arr, (row + half), (col + half), half, result);

                    return;
                }
            }
        }

        result[target]++;
    }

    public static void main(String[] args) {
        CountingQuadsAfterCompression task = new CountingQuadsAfterCompression();

        int[][] arr = {{1,1,1,1,1,1,1,1},{0,1,1,1,1,1,1,1},{0,0,0,0,1,1,1,1},{0,1,0,0,1,1,1,1},{0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,1},{0,0,0,0,1,0,0,1},{0,0,0,0,1,1,1,1}};
        int[][] arr2 = {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};

        System.out.println(Arrays.toString(task.solution(arr2)));
    }

}
