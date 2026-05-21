package programmers.basicTraining.powerOfTwoArray;

// 배열의 길이를 2의 거듭제곱으로 만들기

import utils.Compare;

import java.util.Arrays;

public class PowerOfTwoArray {

    public int[] solution(int[] arr) {
        int size = 0;
        while((int)Math.pow(2, size) < arr.length){
            size++;
        }

        int[] answer = new int[(int)Math.pow(2, size)];

        System.arraycopy(arr, 0, answer, 0, arr.length);

        return answer;
    }

    public int[] solution2(int[] arr){
        int size = 1;
        while(size < arr.length){
            size *= 2;
        }
        return Arrays.copyOf(arr, size);
    }

    public int[] solution3(int[] arr){
        int size = 1;
        while(size < arr.length){
            size *= 2;
        }
        int[] answer = new int[size];
        System.arraycopy(arr, 0, answer, 0, arr.length);
        return answer;
    }

    public static void main(String[] args) {
        PowerOfTwoArray task = new PowerOfTwoArray();
        int[] arr = {58, 172, 746, 89, 2};

        System.out.println(Arrays.toString(task.solution3(arr)));

        Compare.measureTime(()->task.solution3(arr), ()->task.solution2(arr));
    }

}
