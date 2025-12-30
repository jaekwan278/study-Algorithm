package programmers.basicTraining.arithmeticsSequence;

// x만큼 간격이 있는 n개의 숫자

import java.util.Arrays;

public class ArithmeticsSequence {

    public long[] solution(int x, int n) {
        long[] answer = new long[n];

        for(int i = 1; i <= n; i++){
            answer[i-1] = (long) x * i;
        }

        return answer;
    }

    public static void main(String[] args) {
        ArithmeticsSequence task = new ArithmeticsSequence();
        int x = 2, n = 5;

        System.out.println(Arrays.toString(task.solution(x, n)));
    }

}
