package programmers.searchAlgorithm.dfs.travelRoute;

// 여행경로

/*

    Map<String, PriorityQueue<String>> : 출발지 기준 정리, 도착지 사전순 정렬

    dfs
        탈출 조건 : size == tickets.length + 1
        재귀 조건 : 다음 경로 없음 & 사이즈 기준 미충족
        백 트래킹 : 사전순 탐색 이후 역순으로 롤백

 */

import java.util.*;

public class TravelRoute {

    public String[] solution(String[][] tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for(String[] t : tickets){
            map.computeIfAbsent(t[0], k -> new PriorityQueue<>())
                    .add(t[1]);
        }
        List<String> result = new ArrayList<>();

        dfs(map, result, "ICN");

        Collections.reverse(result);

        return result.toArray(String[]::new);
    }

    private void dfs(Map<String, PriorityQueue<String>> map, List<String> result, String target){

        PriorityQueue<String> que = map.get(target);

        while(que != null && !que.isEmpty()){
            dfs(map, result, que.poll());
        }

        result.add(target);
    }

    public static void main(String[] args) {
        TravelRoute task = new TravelRoute();
        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};

        System.out.println(Arrays.toString(task.solution(tickets)));
    }

}
