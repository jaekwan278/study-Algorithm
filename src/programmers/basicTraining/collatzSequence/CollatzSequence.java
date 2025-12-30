package programmers.basicTraining.collatzSequence;

// 콜라츠 수열

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollatzSequence {

    public int[] solution(int n) {
        List<Integer> seq = new ArrayList<>();
        seq.add(n);

        return collatz(n, seq).stream().mapToInt(Integer::intValue).toArray();
    }

    public static List<Integer> collatz(int n, List<Integer> result){
        if(n == 1) return result;

        if(n % 2 == 0) n = n / 2;
        else n = n * 3 + 1;

        result.add(n);

        return collatz(n, result);
    }

    public static void main(String[] args) {
        CollatzSequence task = new CollatzSequence();
        int n = 10;
        System.out.println(Arrays.toString(task.solution(n)));
    }

}
