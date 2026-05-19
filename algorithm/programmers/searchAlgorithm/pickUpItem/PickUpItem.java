package programmers.searchAlgorithm.pickUpItem;

// 아이템 줍기

import java.util.ArrayDeque;
import java.util.Queue;

public class PickUpItem {

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;

        int[][] map = makeMap(rectangle);

        answer = bfs(map, new int[]{characterX*2, characterY*2}, new int[]{itemX*2, itemY*2});

        return answer % 2 == 1 ? answer / 4 + 1 : answer / 4;

    }

    private int[][] makeMap(int[][] rectangle){

        int xMax = -1, yMax = -1;

        for(int[] rec : rectangle){
            xMax = Math.max(rec[2], xMax);
            yMax = Math.max(rec[3], yMax);
        }

        int[][] map = new int[yMax * 2 + 2][xMax * 2 + 2];
        insertRange(rectangle, map);
        deleteRange(rectangle, map);

        return map;
    }

    private void insertRange(int[][] rectangle, int[][] map){

        for(int[] rec : rectangle){
            for(int y = rec[1]*2; y <= rec[3]*2; y++){
                for(int x = rec[0]*2; x <= rec[2]*2; x++){
                    map[y][x] = 1;
                }
            }
        }

    }

    private void deleteRange(int[][] rectangle, int[][] map){

        for(int[] rec : rectangle){
            for(int y = rec[1]*2+1; y <= rec[3]*2-1; y++){
                for(int x = rec[0]*2+1; x <= rec[2]*2-1; x++){
                    map[y][x] = 0;
                }
            }
        }

    }

    private int bfs(int[][] map, int[] ch, int[] it){

        int steps = 0;

        Queue<int[]> que = new ArrayDeque<>();
        que.add(ch);
        map[ch[1]][ch[0]] = 0;

        int[] xDir = {0,0,-1,1};
        int[] yDir = {-1,1,0,0};

        while(!que.isEmpty()){
            int[] cur = que.poll();
            if(cur[0] == it[0] && cur[1] == it[1]) return steps;

            for(int i = 0; i < 4; i++){
                int x = cur[0] + xDir[i];
                int y = cur[1] + yDir[i];

                if(map[y][x] == 1){
                    que.add(new int[]{x, y});
                    map[y][x] = 0;
                }
            }

            steps++;
        }

        return 0;
    }


    public static void main(String[] args) {
        PickUpItem task = new PickUpItem();

        int[][] rectangle = {{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}};
        int characterX = 1;
        int characterY = 3;
        int itemX = 7;
        int itemY = 8;

        System.out.println(task.solution(rectangle, characterX, characterY, itemX, itemY));
    }
}
