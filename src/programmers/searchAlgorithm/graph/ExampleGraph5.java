package programmers.searchAlgorithm.graph;

import java.util.ArrayList;
import java.util.List;

public class ExampleGraph5 implements GraphTemplate{

    private final int N = 5;
    private final List<Integer>[] graph = new ArrayList[N];

    public ExampleGraph5(){
        for(int i = 0; i < N; i++){
            graph[i] = new ArrayList<>();
        }
        addEdge(0, 1);
        addEdge(1, 2);
        addEdge(0, 3);
        addEdge(1, 4);
        addEdge(3, 4);
    }

    @Override
    public int getNodeCount() {
        return this.N;
    }

    @Override
    public List<Integer> getAdjList(int i) {
        return this.graph[i];
    }

    @Override
    public void addEdge(int a, int b) {
        graph[a].add(b);
        graph[b].add(a);
    }
}
