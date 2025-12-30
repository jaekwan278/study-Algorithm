package programmers.basicTraining.calcByArray;

// 배열의 길이에 따라 다른 연산하기

import utils.Compare;

public class CalcByArray {

    public int[] solution(int[] arr, int n) {

        for(int i = 0; i < arr.length; i++){
            if(arr.length % 2 == 0){
                if(i % 2 != 0) arr[i] += n;
            }else{
                if(i % 2 == 0) arr[i] += n;
            }
        }

        return arr;
    }

    public int[] solution2(int[] arr, int n){
        for(int i = (arr.length % 2)^1; i < arr.length; i+=2){
            arr[i] += n;
        }
        return arr;
    }

    public static void main(String[] args) {
        CalcByArray task = new CalcByArray();
        int[] arr = {49, 12, 100, 276, 33};
        int n = 27;

//        System.out.println(Arrays.toString(task.solution(arr, n)));

        Compare.measureTime(()->task.solution(arr, n), ()->task.solution2(arr, n));
    }

}
