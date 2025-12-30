package programmers.searchAlgorithm.bfs.gameMapShortestPath;

// 게임 맵 최단거리

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class GameMapShortestPath {

    public int solution(int[][] maps) {
        int yLen = maps.length;
        int xLen = maps[0].length;

        int[][] steps = new int[yLen][xLen];
        steps[0][0] = 1;

        bfs(maps, steps);

        return steps[yLen-1][xLen-1] == 0 ? -1 : steps[yLen-1][xLen-1];
    }

    private void bfs(int[][] maps, int[][] steps){

        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{0, 0});

        int[] dirX = new int[]{0, 0, -1, 1};
        int[] dirY = new int[]{-1, 1, 0, 0};

        while(!que.isEmpty()){
            int[] cur = que.poll();

            if( (cur[0] == maps.length - 1) && (cur[1] == maps[0].length - 1) ){
                return;
            }

            for(int i = 0; i < 4; i++){
                int x = cur[1] + dirX[i];
                int y = cur[0] + dirY[i];

                if(x < 0 || x > maps[0].length - 1 || y < 0 || y > maps.length - 1){
                    continue;
                }

                if(maps[y][x] == 0 || steps[y][x] != 0){
                    continue;
                }

                steps[y][x] += steps[cur[0]][cur[1]] + 1;
                que.add(new int[]{y, x});
            }
        }
    }

    public static void main(String[] args) {
        GameMapShortestPath task = new GameMapShortestPath();
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};

        System.out.println(task.solution(maps));
    }
}
