package programmers.stackQue.stockPrice;

// 주식 가격

import utils.Compare;

import java.util.Arrays;
import java.util.Stack;

public class StockPrice {

    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]){
                int idx = stack.pop();
                answer[idx] = i - idx;
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            int idx = stack.pop();
            answer[idx] = n - 1 - idx;
        }

        return answer;
    }

    public int[] solution2(int[] prices) {
        int[] answer = new int[prices.length];

        for(int i = 0; i < prices.length; i++){
            int cur = prices[i];
            for(int j = (i + 1); j < prices.length; j++){
                answer[i]++;
                if(prices[j] < cur) break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        StockPrice task = new StockPrice();
        int[] prices = {1, 2, 3, 2, 3};

        System.out.println(Arrays.toString(task.solution(prices)));

        Compare.measureTime(()->task.solution(prices), ()->task.solution2(prices));
    }

}
