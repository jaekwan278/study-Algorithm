package programmers.basicTraining.findInteger;

// 정수 찾기

import java.util.Arrays;

public class FindInteger {

        public int solution(int[] num_list, int n) {

            return Arrays.stream(num_list).anyMatch(i -> i == n) ? 1 : 0;
        }

    public static void main(String[] args) {
        FindInteger task = new FindInteger();
        int[] num_list = {15, 98, 23, 2, 15};
        int n = 15;

        System.out.println(task.solution(num_list, n));
    }
}
