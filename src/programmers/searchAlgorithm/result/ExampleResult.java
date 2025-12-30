package programmers.searchAlgorithm.result;

import programmers.searchAlgorithm.bfs.BFS;
import programmers.searchAlgorithm.dfs.DFS;
import programmers.searchAlgorithm.graph.ExampleGraph5;

public class ExampleResult {

    public static void main(String[] args) {
        ExampleGraph5 graph = new ExampleGraph5();
        BFS bfs = new BFS(graph);
        DFS dfs = new DFS(graph);

        bfs.start(0);
        dfs.startRecursive(0);
    }
}
