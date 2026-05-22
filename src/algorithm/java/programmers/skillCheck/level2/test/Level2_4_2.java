package programmers.skillCheck.level2.test;

public class Level2_4_2 {

    private int game(int[][] dungeons, boolean[] visited, int fatigue){
        int max = 0;

        for(int i = 0; i < dungeons.length; i++){

            if(visited[i]) continue;

            int need = dungeons[i][0];
            int use = dungeons[i][1];

            if(fatigue < need) continue;

            visited[i] = true;

            max = Math.max(max, game(dungeons, visited, fatigue - use) + 1);

            visited[i] = false;
        }

        return max;
    }

    public int solution(int k, int[][] dungeons) {
        int answer = -1;

        boolean[] visited = new boolean[dungeons.length];

        answer = game(dungeons, visited, k);

        return answer;
    }

    public static void main(String[] args) {
        Level2_4_2 task = new Level2_4_2();

        int k = 80;
        int[][] dungeons = {{80,20},{50,40},{30,10}};

        System.out.println(task.solution(k, dungeons));
    }

}
