package programmers.dynamicProgramming.expressN;

// n으로 표현

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExpressN {

    public int solution(int N, int number) {
        int answer = 0;

        List<Set<Integer>> dp = new ArrayList<>();
        dp.add(new HashSet<>());

        for(int i = 1; i <= 8; i++){

            Set<Integer> comb = new HashSet<>();

            int repeat = Integer.parseInt(String.valueOf(N).repeat(i));
            comb.add(repeat);

            for(int j = 1; j < i; j++){

                for(int a : dp.get(j)){
                    for(int b : dp.get(i - j)){
                        comb.add(a + b);
                        comb.add(a - b);
                        comb.add(a * b);
                        if(b != 0) comb.add(a / b);
                    }
                }

            }

            if(comb.contains(number)) return i;

            dp.add(comb);
        }

        return -1;
    }

    public static void main(String[] args) {
        ExpressN task = new ExpressN();
        int N = 2;
        int number = 11;

        System.out.println(task.solution(N, number));
    }

}
