package programmers.basicTraining.topAfterBottomFive;

// 뒤에서 5등 위로

import utils.Compare;

import java.util.Arrays;
import java.util.stream.IntStream;

public class TopAfterBottomFive {

    public int[] solution(int[] num_list) {
        int length = num_list.length - 5;
        int[] answer = new int[length];

        Arrays.sort(num_list);
        System.arraycopy(num_list, 5, answer, 0, length);

        return answer;
    }

    public int[] solution2(int[] num_list){
        Arrays.sort(num_list);
        return Arrays.copyOfRange(num_list, 5, num_list.length);
    }

    public int[] solution3(int[] num_list){

        return IntStream.of(num_list).sorted().skip(5).toArray();
    }

    public static void main(String[] args) {
        TopAfterBottomFive task = new TopAfterBottomFive();
        int[] num_list = {12, 4, 15, 46, 38, 1, 14, 56, 32, 10};

        System.out.println(Arrays.toString(task.solution2(num_list)));

        Compare.measureTime(()->task.solution2(num_list), ()->task.solution3(num_list));
    }

}
