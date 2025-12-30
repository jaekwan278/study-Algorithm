package programmers.basicTraining.makeSquare;

// 정사각형으로 만들기

import java.util.Arrays;

public class MakeSquare {

    public int[][] solution(int[][] arr) {
        int size = Math.max(arr[0].length, arr.length);
        int[][] answer = new int[size][size];


        for(int i = 0; i < arr.length; i++){
            answer[i] = Arrays.copyOf(arr[i], size);
        }

        return answer;
    }

    public static void main(String[] args) {
        MakeSquare task = new MakeSquare();
        int[][] arr = {{57, 192, 534, 2}, {9, 345, 192, 999}};

        for(int[] out : task.solution(arr)){
            System.out.println(Arrays.toString(out));
        }
    }

}
