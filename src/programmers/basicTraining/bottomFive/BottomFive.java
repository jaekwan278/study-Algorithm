package programmers.basicTraining.bottomFive;

// 뒤에서 5등까지

import java.util.Arrays;

public class BottomFive {

    public int[] solution(int[] num_list) {

        Arrays.sort(num_list);

        return Arrays.copyOfRange(num_list, 0, 5);
    }


    public static void main(String[] args) {
        BottomFive task = new BottomFive();
        int[] num_list = {12, 4, 15, 46, 38, 1, 14};

        System.out.println(Arrays.toString(task.solution(num_list)));
    }

}
