package programmers.basicTraining.lengthOperation;

// 길이에 따른 연산

import java.util.Arrays;

public class LengthOperation {

    public int solution(int[] num_list) {
        int answer = 0;

        if(num_list.length >= 11){
            answer = Arrays.stream(num_list)
                    .sum();
        }else{
            answer = Arrays.stream(num_list)
                    .reduce(1, (a, b) -> a * b);
        }

        return answer;
    }

    public static void main(String[] args) {
        LengthOperation task = new LengthOperation();
        int[] num_list = {2, 3, 4, 5};

        System.out.println(task.solution(num_list));
    }

}
