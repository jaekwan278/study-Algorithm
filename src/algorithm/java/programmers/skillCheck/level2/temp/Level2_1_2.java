package programmers.skillCheck.level2.temp;

import java.util.*;

public class Level2_1_2 {

    public int[] solution(String[] maps) {
        int[] answer = {};

        int yLen = maps.length;
        int xLen = maps[0].length();
        boolean[][] isVisited = new boolean[yLen][xLen];

        List<Integer> islands = new ArrayList<>();

        for (int y = 0; y < yLen; y++) {
            for (int x = 0; x < xLen; x++) {
                if (isVisited[y][x]) continue;

                if (Character.isDigit(maps[y].charAt(x))) {
                    islands.add(findIsland(maps, isVisited, y, x));
                }

                isVisited[y][x] = true;
            }
        }

        System.out.println(islands);

        return answer;
    }

    private int findIsland(String[] maps, boolean[][] isVisited, int y, int x) {
        isVisited[y][x] = true;

        int[] yDir = {0, 0, 1, -1};
        int[] xDir = {1, -1, 0, 0};

        int sum = maps[y].charAt(x) - '0';

        for (int i = 0; i < 4; i++) {
            int ny = y + yDir[i];
            int nx = x + xDir[i];

            if (ny >= 0 && ny < maps.length && nx >= 0 && nx < maps[0].length() && !isVisited[ny][nx]){
                if (Character.isDigit(maps[ny].charAt(nx))) {
                    sum += findIsland(maps, isVisited, ny, nx);
                }

                isVisited[ny][nx] = true;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        Level2_1_2 task = new Level2_1_2();

        String[] maps = {"X591X", "X1X5X", "X231X", "1XXX1"};

        System.out.println(Arrays.toString(task.solution(maps)));
    }

}
