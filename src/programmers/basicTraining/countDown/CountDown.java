package programmers.basicTraining.countDown;

// 카운트 다운

import utils.Compare;

import java.util.stream.IntStream;

public class CountDown {

    public int[] solution(int start_num, int end_num) {
        int[] answer = new int[start_num - end_num + 1];

        int cnt = 0;
        while(start_num >= end_num){
            answer[cnt] = start_num;
            cnt++;
            start_num--;
        }

        return answer;
    }

    public int[] solution2(int start_num, int end_num){
        return IntStream.rangeClosed(-start_num, -end_num).map(i -> -i).toArray();
    }

    public static void main(String[] args) {
        CountDown task = new CountDown();
        int start_num = 10, end_num = 3;

//        System.out.println(Arrays.toString(task.solution2(start_num, end_num)));

        Compare.measureTime(()->task.solution(start_num, end_num), ()->task.solution2(start_num, end_num));
    }

}
