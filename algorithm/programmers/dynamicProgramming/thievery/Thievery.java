package programmers.dynamicProgramming.thievery;

// 도둑질

/*



 */

import utils.Compare;

public class Thievery {

    public int solution(int[] money) {
        int answer = 0;

        answer = Math.max(
                calc(money, 0, money.length-2),
                calc(money, 1, money.length-1)
        );

        return answer;
    }

    private int calc(int[] money, int start, int end){
        int prev1 = 0;
        int prev2 = 0;

        for(int i = start; i <= end; i++){

            int cur = Math.max(
                    prev2 + money[i],
                    prev1
            );

            prev2 = prev1;
            prev1 = cur;

        }

        return prev1;
    }

    public int solution2(int[] money) {
        int[][] pick = new int[2][money.length];

        pick[0][0] = money[0];
        pick[0][1] = money[0];
        pick[1][0] = 0;
        pick[1][1] = money[1];

        for(int i=2; i<money.length; i++) {
            pick[0][i] = Math.max(pick[0][i-2] + money[i], pick[0][i-1]);
            pick[1][i] = Math.max(pick[1][i-2] + money[i], pick[1][i-1]);
        }

        return Math.max(pick[0][pick[0].length-2], pick[1][pick[1].length-1]);
    }

    public static void main(String[] args) {
        Thievery task = new Thievery();
        int[] money = {1, 2, 3, 1};

        System.out.println(task.solution(money));

        Compare.measureTime(()-> task.solution(money), ()-> task.solution2(money));
    }

}
