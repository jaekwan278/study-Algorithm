package programmers.basicTraining.untilN;

// N 번째 원소까지

import java.util.Arrays;

public class UntilN {

    public int[] solution(int[] num_list, int n) {
        return Arrays.copyOf(num_list, n);
    }

    public static void main(String[] args) {
        UntilN task = new UntilN();
        int[] num_list = {5, 2, 1, 7, 5};
        int n = 3;

        System.out.println(Arrays.toString(task.solution(num_list, n)));
    }

}
