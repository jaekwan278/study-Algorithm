package programmers.searchAlgorithm.dfs.network;

import programmers.searchAlgorithm.bfs.network.NetWork;
import utils.Compare;

public class Network {
    public int solution(int n, int[][] computers) {
        int answer = 0;

        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                answer++;
                dfs(computers, visited, i, n);
            }
        }

        return answer;
    }

    private void dfs(int[][] computers, boolean[] visited, int idx, int n){
        visited[idx] = true;

        for(int i = 0; i < n; i++){

            if(!visited[i] && computers[idx][i] == 1){
                visited[i] = true;
                dfs(computers, visited, i, n);
            }

        }
    }

    public static void main(String[] args) {
        Network task = new Network();
        NetWork task2 = new NetWork();
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

        System.out.println(task.solution(n, computers));

        Compare.measureTime(()-> task.solution(n, computers), ()-> task2.solution(n, computers));
    }
}
