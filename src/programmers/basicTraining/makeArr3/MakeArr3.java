package programmers.basicTraining.makeArr3;

// 배열 만들기 3

import java.util.Arrays;

public class MakeArr3 {

    public int[] solution(int[] arr, int[][] intervals) {
        int[] a = Arrays.copyOfRange(arr, intervals[0][0], intervals[0][1] + 1);
        int[] b = Arrays.copyOfRange(arr, intervals[1][0], intervals[1][1] + 1);

        int[] answer = new int[a.length + b.length];

        System.arraycopy(a, 0, answer, 0, a.length);
        System.arraycopy(b, 0, answer, a.length, b.length);

        return answer;
    }

    public static void main(String[] args) {
        MakeArr3 task = new MakeArr3();
        int[] arr = {1, 2, 3, 4, 5};
        int[][] intervals = {{1, 3}, {0, 4}};

        System.out.println(Arrays.toString(task.solution(arr, intervals)));
    }

}
