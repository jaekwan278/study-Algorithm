package programmers.basicTraining.changeOrder;

// 순서 바꾸기

import java.util.Arrays;

public class ChangeOrder {

    public int[] solution(int[] num_list, int n) {
        int[] answer = new int[num_list.length];
        int[] front = Arrays.copyOf(num_list, n);
        int[] end = Arrays.copyOfRange(num_list, n, num_list.length);

        System.arraycopy(end, 0, answer, 0, end.length);
        System.arraycopy(front, 0, answer, end.length, front.length);

        return answer;
    }

    public static void main(String[] args) {
        ChangeOrder task = new ChangeOrder();
        int[] num_list = {5, 2, 1, 7, 5};
        int n = 3;

        System.out.println(Arrays.toString(task.solution(num_list, n)));
    }

}
