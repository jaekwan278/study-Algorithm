package programmers.kakao2025.trainTrack;

// 기차 선로

public class TrainTrack {

    private static final int[][] TRACK = {
            {-1, -1, -1, -1},
            {-1, 1, -1, 3},
            {0, -1, 2, -1},
            {0, 1, 2, 3},
            {-1, 0, 3, -1},
            {-1, -1, 1, 0},
            {1, -1, -1, 2},
            {3, 2, -1, -1}
    };
    // 북 동 남 서 (0, 1, 2, 3)
    private static final int[] DX = {-1, 0, 1, 0};
    private static final int[] DY = {0, 1, 0, -1};

    int answer = 0;

    public int solution(int[][] grid) {
        int rLen = grid.length, cLen = grid[0].length;

        dfs(grid, rLen, cLen, 0, 0, 1);

        return answer;
    }

    private void dfs(int[][] grid, int rLen, int cLen, int x, int y, int dir){

        // 장애물 or 이탈 여부
        if(x < 0 || y < 0 || x >= rLen || y >= cLen || grid[x][y] == -1) return;

        // 도착
        if(x == rLen-1 && y == cLen-1){
            if(isValidTrack(grid, rLen, cLen) && TRACK[grid[rLen-1][cLen-1]][dir] >= 0) {
                answer++;
                return;
            }
        }

        int nDir = 0;
        // 트랙 존재 유무
        if(grid[x][y] != 0){

            nDir = TRACK[grid[x][y]][dir];
            if(nDir >= 0){
                dfs(grid, rLen, cLen, (x + DX[nDir]), (y + DY[nDir]), nDir);
            }
        }else{

            for(int i = 1; i < 8; i++){

                nDir = TRACK[i][dir];

                if(nDir < 0) continue;

                int nx = x + DX[nDir];
                int ny = y + DY[nDir];

                grid[x][y] = i;
                dfs(grid, rLen, cLen, nx, ny, nDir);
                grid[x][y] = 0;     // 백트래킹
            }
        }
    }

    private boolean isValidTrack(int[][] grid, int rLen, int cLen){

        int cnt = 0;

        for(int i = 0; i < rLen; i++){
            for(int j = 0; j < cLen; j++){

                int cur = grid[i][j];

                if(cur == 3) cnt += 2;
                else if(cur > 0) cnt++;
            }
        }

        int x = 0, y = 0, dir = 1;
        while (x != rLen - 1 || y != cLen - 1) {

            cnt--;

            dir = TRACK[grid[x][y]][dir];
            x += DX[dir];
            y += DY[dir];

        }

        return cnt == 1;
    }

    public static void main(String[] args) {
        TrainTrack task = new TrainTrack();

        int[][] grid = {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 1}};

        System.out.println(task.solution(grid));
    }

}
