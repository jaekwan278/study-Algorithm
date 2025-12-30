package programmers.searchAlgorithm.bfs.network;

// 네트워크

import java.util.ArrayDeque;
import java.util.Queue;

public class NetWork {

    public int solution(int n, int[][] computers) {
        int answer = 0;

        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                answer++;
                bfs(computers, visited, i, n);
            }
        }

        return answer;
    }

    private void bfs(int[][] computers, boolean[] visited, int idx, int n){

        Queue<Integer> link = new ArrayDeque<>();
        link.offer(idx);
        visited[idx] = true;

        while(!link.isEmpty()){
            int cur = link.poll();

            for(int i = 0; i < n; i++){

                if(computers[cur][i] == 1 && !visited[i]){
                    link.offer(i);
                    visited[i] = true;
                }

            }
        }
    }

    public static void main(String[] args) {
        NetWork task = new NetWork();
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

        System.out.println(task.solution(n, computers));
    }

}
