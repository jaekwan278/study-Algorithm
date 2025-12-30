package programmers.basicTraining.countUp;

// 카운트 업

import utils.Compare;

import java.util.Arrays;
import java.util.stream.IntStream;

public class CountUp {

    public int[] solution(int start_num, int end_num) {
        return IntStream.rangeClosed(start_num, end_num).toArray();
    }

    public int[] solution2(int start_num, int end_num){
        int[] answer = new int[end_num - start_num + 1];

        int cnt = 0;
        for(int i = start_num; i <= end_num; i++){
            answer[cnt++] = i;
        }

        return answer;
    }

    public static void main(String[] args) {
        CountUp task = new CountUp();
        int start_num = 3, end_num = 10;

        System.out.println(Arrays.toString(task.solution2(start_num, end_num)));

        Compare.measureTime(()->task.solution(start_num, end_num), ()->task.solution2(start_num, end_num));
    }
}
