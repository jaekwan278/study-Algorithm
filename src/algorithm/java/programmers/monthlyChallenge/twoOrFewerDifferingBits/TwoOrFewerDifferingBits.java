package programmers.monthlyChallenge.twoOrFewerDifferingBits;

// 2개 이하로 다른 비트

import java.util.Arrays;

public class TwoOrFewerDifferingBits {

    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for(int i = 0; i < numbers.length; i++){

            long cur = numbers[i];

            if(cur % 2 == 0){
                answer[i] = cur + 1;
            }else{
                long mask = ~cur & (cur + 1);

                answer[i] = cur + (mask >>> 1);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        TwoOrFewerDifferingBits task = new TwoOrFewerDifferingBits();

        long[] numbers = {2, 7};

        System.out.println(Arrays.toString(task.solution(numbers)));
    }

}

/*
    n       111
    ~n      1000
    tIdx    3


 */