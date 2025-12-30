package programmers.exhaustiveSearch.mockTest;

// 모의고사

import utils.Compare;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MockTest {

    private static final int[] a1 = {1, 2, 3, 4, 5};
    private static final int[] a2 = {2, 1, 2, 3, 2, 4, 2, 5};
    private static final int[] a3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    public int[] solution(int[] answers) {
        int[] answer = new int[3];

        for (int i = 0; i < answers.length; i++) {
            int ans = answers[i];

            if (ans == a1[i % a1.length]) answer[0]++;
            if (ans == a2[i % a2.length]) answer[1]++;
            if (ans == a3[i % a3.length]) answer[2]++;
        }

        int max = Math.max(answer[0], Math.max(answer[1], answer[2]));

        return IntStream.range(0, 3)
                .filter(i -> answer[i] == max)
                .map(i -> i+1)
                .toArray();
    }

    public static void main(String[] args) {
        MockTest task = new MockTest();
        int[] answers = {1,3,2,4,2};

        System.out.println(Arrays.toString(task.solution(answers)));
    }
}

