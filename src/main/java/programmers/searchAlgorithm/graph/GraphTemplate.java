package programmers.searchAlgorithm.graph;

import java.util.List;

public interface GraphTemplate {

    // 노드 수 반환
    int getNodeCount();
    // 인접 노드 리스트 반환
    List<Integer> getAdjList(int i);
    // 간선 추가
    void addEdge(int a, int b);

}
