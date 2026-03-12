package programmers.summerWinter2018.lengthOfVisit;

// 방문 길이

import utils.Compare;

import java.util.HashSet;
import java.util.Set;

public class LengthOfVisit {

    public int solution(String dirs) {
        int x = 0, y = 0;
        Set<String> set = new HashSet<>();

        for(char cur : dirs.toCharArray()){

            int bx = x;
            int by = y;

            switch (cur){
                case('U') : y++; break;
                case('D') : y--; break;
                case('L') : x--; break;
                case('R') : x++; break;
            }

            String path1 = x + "," + y + "," + bx + "," + by;
            String path2 = bx + "," + by + "," + x + "," + y;

            set.add(path1);
            set.add(path2);
        }

        return set.size() / 2;
    }

    public int solution2(String dirs) {
        int answer = 0;

        int[] dy = {0, 0, -1, 1};
        int[] dx = {-1, 1, 0, 0};

        boolean[][][] visited = new boolean[11][11][4];
        int x = 5, y = 5;

        String dir = "LRDU";
        int[] opposite = new int[]{1, 0, 3, 2};

        for(char cur : dirs.toCharArray()){

            int d = dir.indexOf(cur);

            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx < 0 || nx > 10 || ny < 0 || ny > 10) continue;

            if(!visited[nx][ny][d]){
                visited[nx][ny][d] = true;
                visited[x][y][opposite[d]] = true;
                answer++;
            }

            x = nx;
            y = ny;
        }

        return answer;
    }

    public static void main(String[] args) {
        LengthOfVisit task = new LengthOfVisit();

        String dirs = "ULURRDLLU";

        System.out.println(task.solution2(dirs));

        Compare.measureTime(()->task.solution(dirs), ()->task.solution2(dirs));
    }

}
