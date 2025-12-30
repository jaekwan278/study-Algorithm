package programmers.basicTraining.intervalElements;

// n 개 간격의 원소들

import java.util.Arrays;

public class IntervalElements {

    public int[] solution(int[] num_list, int n) {
        int length = (num_list.length + n - 1) / n;
        int[] answer = new int[length];

        for(int i = 0; i < length; i++){
            answer[i] = num_list[n * i];
        }

        return answer;
    }

    public static void main(String[] args) {
        IntervalElements task = new IntervalElements();
        int[] num_list = {4, 2, 6, 1, 7, 6};
        int n = 2;

        System.out.println(Arrays.toString(task.solution(num_list, n)));
    }

}
