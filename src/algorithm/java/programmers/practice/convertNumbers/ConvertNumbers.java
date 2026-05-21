package programmers.practice.convertNumbers;

// 숫자 변환하기

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class ConvertNumbers {

//    private final int[] dp = new int[3000003];
//    private final int INF = 1000002;

//    메모리  초과
    public int solution2(int x, int y, int n) {
        if(x == y) return 0;

        int answer = 1;
        List<Integer> cur = new ArrayList<>(List.of(x + n, x * 2, x * 3));

        int min = y - 1;
        while(min < y){
            List<Integer> next = new ArrayList<>();

            for(int k : cur){
                if(k > y) continue;
                if(k == y) return answer;

                int n1 = k + n;
                int n2 = k * 2;
                int n3 = k * 3;

                min = Math.max(Math.min(n1, n2), min);
                next.addAll(List.of(n1, n2, n3));
            }

            answer++;
            cur = next;
        }

        return -1;
    }

    public int solution(int x, int y, int n) {
        int answer = 0;

        boolean[] visited = new boolean[y + 1];
        ArrayDeque<int[]> que = new ArrayDeque<>();

        que.add(new int[]{x, 0});
        visited[x] = true;

        while(!que.isEmpty()){
            int[] cur = que.poll();
            int val = cur[0];
            int level = cur[1];

            if(val == y) return level;

            int[] next = new int[]{val + n, val * 2, val * 3};

            for(int nx : next){
                if(nx > y) continue;

                if(!visited[nx]){
                    visited[nx] = true;
                    que.offer(new int[]{nx, level+1});
                }
            }
        }

        return -1;
    }

//    public int solution3(int x, int y, int n) {
//        int answer = 0;
//        Arrays.fill(dp, INF);
//        dp[x] = -1;
//        dp[y] = 0;
//        for(int num = Math.max(y - n, Math.max(y / 2, y / 3)); num >= x; num--){
//            dp[num] = Math.min(dp[num + n] + 1, Math.min(dp[num * 2] + 1, dp[num * 3] + 1));
//        }
//        return dp[x] >= INF ? -1 : dp[x];
//    }

    public static void main(String[] args) {
        ConvertNumbers task = new ConvertNumbers();

        int x = 2, y = 5, n = 4;

        System.out.println(task.solution(x, y, n));

//        A win
//        Compare.measureTime(()->task.solution(x, y, n), ()->task.solution3(x, y, n));
    }

}
