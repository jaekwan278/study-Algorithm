package programmers.exhaustiveSearch.fatigue;

// 피로도

/*

    1. dfs + 백트래킹

 */

    import java.util.ArrayList;
    import java.util.List;

public class Fatigue {

    public int solution(int k, int[][] dungeons) {

        boolean[] visited = new boolean[dungeons.length];
        List<List<Integer>> result = new ArrayList<>();

        findOptimalPaths(dungeons, result, new ArrayList<>(), visited, k);

        return result.stream()
                .mapToInt(List::size)
                .max()
                .orElse(0);
    }

    private static void findOptimalPaths(int[][] dungeons, List<List<Integer>> result, List<Integer> path, boolean[] visited, int fatigue){

        boolean canMore = false;

        for(int i = 0; i < dungeons.length; i++){
            if(!visited[i] && dungeons[i][0] <= fatigue){
                canMore = true;

                fatigue -= dungeons[i][1];
                visited[i] = true;
                path.add(i);

                findOptimalPaths(dungeons, result, path, visited, fatigue);

                fatigue += dungeons[i][1];
                visited[i] = false;
                path.remove(path.size() - 1);

            }
        }

        if(!canMore){
            result.add(new ArrayList<>(path));
        }
    }


    public static void main(String[] args) {
        Fatigue task = new Fatigue();

        int k = 80;
        int[][] dungeons = {{80,20},{50,40},{30,10}};

        System.out.println(task.solution(k, dungeons));
    }

}
