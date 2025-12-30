package programmers.exhaustiveSearch.dividePower;

// 전력망을 둘로 나누기

import java.util.ArrayList;
import java.util.List;

public class DividePower {

    public int solution(int n, int[][] wires) {
        int answer = n;

        List<Integer>[] graph = new ArrayList[n + 1];
        for(int i = 1; i < n+1; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] w : wires){
            graph[w[0]].add(w[1]);
            graph[w[1]].add(w[0]);
        }
        boolean[] visited = new boolean[n + 1];
        int[] subTree = new int[n + 1];
        calcSubTreeSize(1, visited, subTree, graph);

        for(int s : subTree){
            if(s == n) continue;
            answer = Math.min(answer, Math.abs(s - (n - s)));
        }

        return answer;
    }

    private static int calcSubTreeSize(int node, boolean[] visited, int[] subTree, List<Integer>[] graph){
        subTree[node] = 1;
        visited[node] = true;

        for(int n : graph[node]){
            if(visited[n]) continue;
            subTree[node] += calcSubTreeSize(n, visited, subTree, graph);
        }

        return subTree[node];
    }

    public static void main(String[] args) {

        DividePower task = new DividePower();

        int n = 9;
        int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};

        System.out.println(task.solution(n, wires));

    }

}
