package programmers.basicTraining.makeArray;

// 배열 만들기 1

import java.util.Arrays;
import java.util.stream.IntStream;

public class MakeArray {

    public int[] solution(int n, int k) {

        return IntStream.rangeClosed(1, n).filter(i -> i % k == 0).toArray();
    }

    public static void main(String[] args) {
        MakeArray task = new MakeArray();
        int n = 10, k = 3;

        System.out.println(Arrays.toString(task.solution(n, k)));
    }

}
