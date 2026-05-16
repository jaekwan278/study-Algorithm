package programmers.graph.ranking;

// 순위

/*

    연결 리스트 & 랭킹 리스트

 */

/*

    0
    1 : 2, 5
    2 : 5
    3 : 2, 5
    4 : 3, 2, 5

 */

import utils.Compare;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Ranking {

    public int solution(int n, int[][] results) {
        int answer = 0;

        List<List<Integer>> winGraph = new ArrayList<>();
        List<List<Integer>> loseGraph = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            winGraph.add(new ArrayList<>());
            loseGraph.add(new ArrayList<>());
        }
        for(int[] r : results){
            winGraph.get(r[0]).add(r[1]);
            loseGraph.get(r[1]).add(r[0]);
        }

        for(int i = 1; i < n+1; i++){
            int rate = rateScan(winGraph, i) + rateScan(loseGraph, i);

            if(rate == n-1) answer++;
        }

        return answer;
    }

    private int rateScan(List<List<Integer>> graph, int target){
        int cnt = 0;
        boolean[] visited = new boolean[graph.size()];
        Queue<Integer> que = new ArrayDeque<>();
        que.add(target);
        visited[target] = true;

        while(!que.isEmpty()){
            int cur = que.poll();

            for(Integer next : graph.get(cur)){

                if(!visited[next]){
                    que.add(next);
                    visited[next] = true;
                    cnt++;
                }

            }
        }

        return cnt;
    }

    private int solution2(int n, int[][] results){
        int answer = 0;

        boolean[][] win = new boolean[n+1][n+1];
        for(int[] r : results){
            win[r[0]][r[1]] = true;
        }

        // 건너서 이김 ?
        for(int k = 1; k <= n; k++){

            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){

                    if (win[i][k] && win[k][j]) {
                        win[i][j] = true;
                    }

                }
            }

        }

        for(int i = 1; i <= n; i++){
            int cnt = 0;

            for(int j = 1; j <= n; j++){

                if(i == j) continue;

                if(win[i][j] || win[j][i]) cnt++;

            }

            if(cnt == n - 1) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Ranking task = new Ranking();
        int n = 5;
        int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};

        System.out.println(task.solution2(n, results));

        Compare.measureTime(()->task.solution(n, results), ()->task.solution2(n, results));
    }

}
