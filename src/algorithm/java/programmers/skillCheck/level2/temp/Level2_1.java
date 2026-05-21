package programmers.skillCheck.level2.temp;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Level2_1 {

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for(int i = 0; i < prices.length; i++){
            int cur = prices[i];
            int cnt = 0;

            for(int j = i + 1; j < prices.length; j++){
                int next = prices[j];
                cnt++;
                if(cur > next){
                    break;
                }
            }

            answer[i] = cnt;
        }

        return answer;
    }

    public int[] solution2(int[] prices){
        int[] answer = new int[prices.length];

        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < prices.length; i++){

            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]){
                int idx = stack.pop();
                answer[idx] = i - idx;
            }

            stack.push(i);
        }

        while(!stack.isEmpty()){
            int idx = stack.pop();
            answer[idx] = prices.length - 1 - idx;
        }

        return answer;
    }

    public static void main(String[] args) {
        Level2_1 task = new Level2_1();

        int[] prices = {1, 2, 3, 2, 3};

        System.out.println(Arrays.toString(task.solution2(prices)));
    }

}
