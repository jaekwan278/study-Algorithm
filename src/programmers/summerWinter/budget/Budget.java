package programmers.summerWinter.budget;

// 예산

import utils.Compare;

import java.util.Arrays;

public class Budget {

    public int solution(int[] d, int budget) {
        int answer = 0;

        Arrays.sort(d);

        for(int i = 0; i < d.length; i++){
            budget -= d[i];

            if(budget < 0) break;

            answer++;
        }

        return answer;
    }

    public int solution2(int[] d, int budget) {
        int answer = 0;

        Arrays.sort(d);

        for (int i = 0; i < d.length; i++) {
            budget -= d[i];

            if (budget < 0) break;

            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Budget task = new Budget();
        int[] d = {1,3,2,5,4};
        int budget = 9;

        System.out.println(task.solution(d, budget));

        Compare.measureTime(() -> task.solution(d, budget), () -> task.solution2(d, budget));
    }

}
