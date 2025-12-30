package programmers.basicTraining.fromN;

// n 번째 원소부터

import java.util.Arrays;

public class FromN {

    public int[] solution(int[] num_list, int n) {

        return Arrays.copyOfRange(num_list, (n - 1), num_list.length);
    }

    public static void main(String[] args) {
        FromN task = new FromN();
        int[] num_list = {5, 2, 1, 7, 5};
        int n = 2;

        System.out.println(Arrays.toString(task.solution(num_list, n)));
    }
}
