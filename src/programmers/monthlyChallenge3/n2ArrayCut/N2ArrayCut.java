package programmers.monthlyChallenge3.n2ArrayCut;

// n^2 배열 자르기

import utils.Compare;

import java.util.Arrays;
import java.util.stream.LongStream;

/*
    4

    1 2 3 4
    2 2 3 4
    3 3 3 4
    4 4 4 4

    { 4 3 3 3 4 4 4 4 }

    7, 14

    div = 1, remain = 3;
 */

public class N2ArrayCut {

    public int[] solution(int n, long left, long right) {
        int len = (int) (right - left + 1);
        int[] answer = new int[len];

        for (int i = 0; i < len; i++) {
            long idx = left + i;

            int row = (int) (idx / n);
            int col = (int) (idx % n);

            answer[i] = Math.max(row + 1, col + 1);
        }

        return answer;
    }

    public int[] solution2(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];

        int[] row = new int[n];
        int div = (int) (left / n);

        for (int i = 0; i < n; i++) {

            row[i] = (i <= div) ? (div + 1) : (i + 1);
        }

        int remain = (int) (left % n);
        for (int i = 0; i < answer.length; i++) {
            int cur = row[remain++];
            answer[i] = cur;

            if (remain >= n) {
                div++;
                Arrays.fill(row, 0, (div + 1), (div + 1));
                remain = 0;
            }
        }

        return answer;
    }

    public int[] solution3(int n, long left, long right) {

        return LongStream.rangeClosed(left, right)
                .mapToInt(value -> (int)(Math.max((value / n), (value % n)) + 1)).toArray();
    }

    public static void main(String[] args) {
        N2ArrayCut task = new N2ArrayCut();
        int n = 4, left = 7, right = 14;

        System.out.println(Arrays.toString(task.solution3(n, left, right)));

        Compare.measureTime(() -> task.solution3(n, left, right), () -> task.solution(n, left, right));
    }

}
