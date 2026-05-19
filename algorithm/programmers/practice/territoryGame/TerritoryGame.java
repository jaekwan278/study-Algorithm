package programmers.practice.territoryGame;

// 땅따먹기

import java.util.Arrays;

public class TerritoryGame {

    int solution(int[][] land) {
        int answer = 0;

        int[] prev = new int[4];
        int[] curr = new int[4];

        // 초기화
        for(int i = 0; i < 4; i++) prev[i] = land[0][i];

        // dp
        for(int i = 1; i < land.length; i++){

            for(int j = 0; j < 4; j++){

                int max = 0;

                for(int k = 0; k < 4; k++){
                    if(j == k) continue;

                    max = Math.max(max, prev[k]);
                }

                curr[j] = land[i][j] + max;
            }

            prev = curr.clone();
        }

        // 최대값
        for(int cur : curr){
            answer = Math.max(answer, cur);
        }

        return answer;
    }

    public static void main(String[] args) {
        TerritoryGame task = new TerritoryGame();
        int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};

        System.out.println(task.solution(land));
    }

}