package programmers.basicTraining.conditionSequence;

// 조건에 맞게 수열 반환하기

import java.util.Arrays;

public class ConditionSequence {

    public int[] solution(int[] arr) {
        int[] answer = new int[arr.length];

        for(int i = 0; i < arr.length; i++){
            int remain = arr[i] % 2;
            if((arr[i] >= 50) && (remain == 0)){
                answer[i] = arr[i] / 2;
            }else if(arr[i] < 50 && (remain != 0)){
                answer[i] = arr[i] * 2;
            }else{
                answer[i] = arr[i];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        ConditionSequence task = new ConditionSequence();
        int[] arr = {1, 2, 3, 100, 99, 98};

        System.out.println(Arrays.toString(task.solution(arr)));
    }

}
