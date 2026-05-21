package programmers.basicTraining.intSortDescending;

// 정수 내림차순으로 배치하기

import java.util.Arrays;
import java.util.Comparator;

public class IntSortDescending {

    public long solution(long n) {
        return Long.parseLong(
                Arrays.stream(String.valueOf(n).split(""))
                        .sorted(Comparator.reverseOrder())
                        .reduce("", (a, b) -> a + b)
        );
    }

    public static void main(String[] args) {
        IntSortDescending task = new IntSortDescending();
        long n = 118372;

        System.out.println(task.solution(n));
    }

}
