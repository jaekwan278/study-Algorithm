package programmers.practice.longJump;

// 멀리 뛰기

import java.util.ArrayDeque;
import java.util.Deque;

public class LongJump {

    public long solution(int n) {
        long answer = 0;

        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(1);
        deque.add(2);

        while(!deque.isEmpty()){

            int cur = deque.poll();

            for(int i = 1; i < 3; i++){
                int sum = cur + i;

                if(sum == n){
                    answer++;
                }else if(sum < n){
                    deque.add(sum);
                }
            }
        }

        return answer;
    }

    public int solution2(int n){
        if(n == 1) return 1;
        if(n == 2) return 2;

        int a = 1, b = 2;

        for(int i = 3; i <= n; i++){
            int c = (a + b) % 1234567;

            a = b;
            b = c;
        }

        return b;
    }

    public int solution3(int n){
        int[] memo = new int[n+1];

        return dfs(memo, n);
    }

    private int dfs(int[] memo, int n){

        if(n <= 2) return n;
        if(memo[n] != 0) return memo[n];
        return memo[n] = (dfs(memo, n - 2) + dfs(memo, n - 1)) % 1234567;
    }


    public static void main(String[] args) {
        LongJump task = new LongJump();
        int n = 2000;

        System.out.println(task.solution3(n));
    }

}
