package programmers.searchAlgorithm.bfs;

import programmers.searchAlgorithm.graph.GraphTemplate;

import java.util.ArrayDeque;
import java.util.Queue;

public class BFS {

    private final GraphTemplate graph;
    private final boolean[] visited;
    private final Queue<Integer> queue = new ArrayDeque<>();

    public BFS(GraphTemplate graph){
        this.graph = graph;
        this.visited = new boolean[graph.getNodeCount()];
    }

    public void start(int start){

        visited[start] = true;
        queue.add(start);

        System.out.println("BFS 탐색 시작:");

        while(!queue.isEmpty()){
            // 큐에서 꺼냄
            int cur = queue.poll();
            System.out.print(cur + " > ");

            for(int next : graph.getAdjList(cur)){
                if(!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }

        System.out.println("END");
    }



}
