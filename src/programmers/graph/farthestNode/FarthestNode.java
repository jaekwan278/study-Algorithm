package programmers.graph.farthestNode;

// 가장 먼 노드

import utils.Compare;

import java.sql.Array;
import java.util.*;

public class FarthestNode {

    public int solution(int n, int[][] edge) {
        int answer = 0;

        int[] depth = new int[n+1];
        boolean[] visited = new boolean[n+1];

        int max = bfs(edge, 1, visited, depth);

        for(int d : depth){
            if(d == max) answer++;
        }

        return answer;
    }

    private int bfs(int[][] edge, int idx, boolean[] visited, int[] depth){
        int max = 0;
        Queue<Integer> que = new ArrayDeque<>();
        que.add(idx);
        visited[idx] = true;

        while(!que.isEmpty()){
            int cur = que.poll();
            int dep = depth[cur];

            for(int[] ed : edge){

                if(ed[0] == cur || ed[1] == cur){

                    int pair = (ed[0] == cur) ? ed[1] : ed[0];

                    if(!visited[pair]){

                        que.add(pair);
                        visited[pair] = true;
                        depth[pair] = dep + 1;
                        max = depth[pair];

                    }
                }
            }
        }

        return max;
    }

    //------------------------------------------------------------------------------------------------------

    public int solution2(int n, int[][] edge) {
        int answer = 0;

        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] e : edge){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        int[] depth = new int[n+1];
        Arrays.fill(depth, -1);

        bfs2(depth, graph);

        return maxCount(depth);
    }

    private void bfs2(int[] depth, List<List<Integer>> graph){
        Queue<Integer> que = new ArrayDeque<>();
        que.add(1);
        depth[1] = 0;

        while(!que.isEmpty()){
            int cur = que.poll();

            for(int next : graph.get(cur)){

                if(depth[next] < 0){
                    depth[next] = depth[cur] + 1;
                    que.add(next);
                }

            }
        }
    }

    private int maxCount(int[] depth){

        int max = Integer.MIN_VALUE;
        for(int n : depth){
            max = Math.max(max, n);
        }

        int cnt = 0;
        for(int n : depth) {
            if(max == n) cnt++;
        }

        return cnt;
    }

    // que -> 1 3 2

    public static void main(String[] args) {
        FarthestNode task = new FarthestNode();

        int n = 6;
        int[][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};

        Compare.measureTime(()->task.solution(n, vertex), ()->task.solution2(n, vertex));
    }

}
