package programmers.basicTraining.sequenceWithCondition2;

// 조건에 맞게 수열 반환하기 2

import utils.Compare;

import java.util.Arrays;

public class SequenceWithCondition2 {

    public int solution(int[] arr) {
        int answer = -1;
        int[] before = new int[arr.length];

        while(!Arrays.equals(arr, before)){
            before = arr.clone();
            for(int i = 0; i < arr.length; i++){
                if(arr[i] >= 50 && arr[i] % 2 == 0){
                    arr[i] /= 2;
                }else if(arr[i] < 50 && arr[i] % 2 == 1){
                    arr[i] = arr[i] * 2 + 1;
                }
            }
            answer++;
        }

        return answer;
    }

    public int solution2(int[] arr){
        int answer = -1;
        boolean same;

        do{
            same = false;
            for(int i = 0; i < arr.length; i++){
                int before = arr[i];

                if(arr[i] >= 50 && arr[i] % 2 == 0){
                    arr[i] /= 2;
                }else if(arr[i] < 50 && arr[i] % 2 == 1){
                    arr[i] = arr[i] * 2 + 1;
                }

                if(arr[i] != before) same = true;
            }
            answer++;
        }while(same);

        return answer;
    }

    public static void main(String[] args) {
        SequenceWithCondition2 task = new SequenceWithCondition2();
        int[] arr = {1, 2, 3, 100, 99, 98};

        System.out.println(task.solution2(arr));

        Compare.measureTime(()->task.solution(arr), ()->task.solution2(arr));
    }

}
