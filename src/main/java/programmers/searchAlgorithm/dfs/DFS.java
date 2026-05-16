package programmers.searchAlgorithm.dfs;

import programmers.searchAlgorithm.graph.GraphTemplate;

public class DFS {

    private final GraphTemplate graph;
    private final boolean[] visited;


    public DFS(GraphTemplate graph){
        this.graph = graph;
        this.visited = new boolean[graph.getNodeCount()];
    }

    // DFS 재귀
    private void dfsRecursive(int node){
        visited[node] = true;
        System.out.print(node + " > ");

        for(int next : graph.getAdjList(node)){
            if(!visited[next]) {
                dfsRecursive(next);
            }
        }
    }

    public void startRecursive(int start) {
        System.out.println("DFS 재귀형 탐색 시작:");
        dfsRecursive(start);
        System.out.println("END");
    }

}
