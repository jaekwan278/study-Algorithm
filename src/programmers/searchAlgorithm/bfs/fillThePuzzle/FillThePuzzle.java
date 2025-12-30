package programmers.searchAlgorithm.bfs.fillThePuzzle;

// 퍼즐 조각 채우기

import utils.Compare;

import java.util.*;

public class FillThePuzzle {

    private static class Puzzle{
        int size;
        int[][] piece;

        Puzzle(List<int[]> piece){
            this.size = piece.size();

            int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
            int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;

            for(int[] p : piece){
                minX = Math.min(minX, p[1]);
                minY = Math.min(minY, p[0]);
                maxX = Math.max(maxX, p[1]);
                maxY = Math.max(maxY, p[0]);
            }
            maxX -= minX;
            maxY -= minY;

            this.piece = new int[maxY+1][maxX+1];

            for(int[] p : piece){
                this.piece[p[0]-minY][p[1]-minX] = 1;
            }
        }

        private void rotate(){
            int newH = piece[0].length;
            int newW = piece.length;

            int[][] result = new int[newH][newW];

            for(int x = 0; x < piece[0].length; x++){
                for(int y = 0; y < piece.length; y++){
                    result[x][piece.length - y - 1] = piece[y][x];
                }
            }

            this.piece = result;
        }
    }

    // 00 10 11 -> 02 01 00

    public int solution(int[][] game_board, int[][] table) {

        List<Puzzle> blanks = extractPieces(copy(game_board), 0);
        List<Puzzle> puzzles = extractPieces(table, 1);

        blanks.sort((a, b) -> b.size - a.size);
        puzzles.sort((a, b) -> b.size - a.size);

        return gameStart(blanks, puzzles);
    }

    private int[][] copy(int[][] origin){
        int[][] copy = new int[origin.length][];

        for(int i = 0; i < copy.length; i++){
            copy[i] = origin[i].clone();
        }

        return copy;
    }

    private List<Puzzle> extractPieces(int[][] target, int std){
        List<Puzzle> result = new ArrayList<>();

        for(int i = 0; i < target.length; i++){
            for(int j = 0; j < target[0].length; j++){

                if(target[i][j] == std){
                    List<int[]> piece = new ArrayList<>();
                    Puzzle puzzle = findConnections(target, piece, new int[]{i, j}, std);
                    result.add(puzzle);
                }

            }
        }

        return result;
    }

    private Puzzle findConnections(int[][] target, List<int[]> piece, int[] yx, int std){
        int[] xDir = {0, 0, -1, 1};
        int[] yDir = {-1, 1, 0, 0};

        piece.add(new int[]{yx[0], yx[1]});
        target[yx[0]][yx[1]] = -1;

        for(int i = 0; i < 4; i++){
            int x = yx[1] + xDir[i];
            int y = yx[0] + yDir[i];

            if(x < 0 || y < 0 || x >= target.length || y >= target.length){
                continue;
            }

            if(target[y][x] == std){
                findConnections(target, piece, new int[]{y, x}, std);
            }
        }

        return new Puzzle(piece);
    }

    private int gameStart(List<Puzzle> blanks, List<Puzzle> puzzles){
        int count = 0;

        for (Puzzle blank : blanks) {
            boolean isMatch = false;

            for (int j = 0; j < puzzles.size(); j++) {
                Puzzle puzzle = puzzles.get(j);

                if (blank.size == puzzle.size) {

                    for (int k = 0; k < 4; k++) {

                        if (Arrays.deepEquals(blank.piece, puzzle.piece)) {
                            count += blank.size;
                            puzzles.remove(j);
                            isMatch = true;
                            break;
                        } else {
                            puzzle.rotate();
                        }

                    }

                }

                if (isMatch) break;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        FillThePuzzle task = new FillThePuzzle();
        Solution task2 = new Solution();

        int[][] game_board = {{1,1,0,0,1,0},{0,0,1,0,1,0},{0,1,1,0,0,1},{1,1,0,1,1,1},{1,0,0,0,1,0},{0,1,1,1,0,0}};
        int[][] table = {{1,0,0,1,1,0},{1,0,1,0,1,0},{0,1,1,0,1,1},{0,0,1,0,0,0},{1,1,0,1,1,0},{0,1,0,0,0,0}};

        System.out.println(task.solution(game_board, table));

        Compare.measureTime(()->task.solution(game_board, table), ()->task2.solution(game_board, table));
    }

    private static class Solution {
        public class Node {
            int x, y;

            Node(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
        public ArrayList<String> emptyList = new ArrayList<>();
        public int N;
        public int[] dx = {0, 0, -1, 1};
        public int[] dy = {-1, 1, 0, 0};

        public int solution(int[][] game_board, int[][] table) {
            N = game_board.length;
            int answer = 0;

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N ; j++) {
                    if(game_board[i][j] == 0) {
                        emptyList.add(bfs(game_board, i, j, 0));
                    }
                }
            }

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N ; j++) {
                    if(table[i][j] == 1) {
                        answer += find(bfs(table, i, j, 1));
                    }
                }
            }

            return answer;
        }

        public int find(String s) {
            // System.out.println("s : " + s);
            int point = 0;

            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '1') point++;
            }

            for(int i = 0; i < emptyList.size(); i++) {
                String str = emptyList.get(i);

                for(int j = 0; j < 4; j++) {
                    str = rotate(str);
                    // System.out.println(str);
                    if(s.equals(str)) {
                        emptyList.remove(i);
                        return point;
                    }
                }
            }

            return 0;
        }

        public String rotate(String s) {
            String str = "";
            int x = 0;
            int y = 0;

            for(int i = 0; i < s.length(); i++) {
                if(x == 0) {
                    if(s.charAt(i) != ' ') {
                        y++;
                    }
                }
                if(s.charAt(i) == ' ') {
                    x++;
                }
            }

            char[][] arr = new char[x][y];
            StringTokenizer st = new StringTokenizer(s);

            for(int i = 0; i < x; i++) {
                arr[i] = st.nextToken().toCharArray();
            }

            for(int j = 0; j < y; j++) {
                for(int i = x - 1; i >= 0; i--) {
                    str += arr[i][j];
                }
                str += " ";
            }

            return str;
        }

        public String bfs(int[][] arr, int i, int j, int mode) {
            // mode 0 : game_board, mode 1 : table
            String s = "";
            ArrayDeque<Node> q = new ArrayDeque<>();
            boolean[][] tmp = new boolean[N][N];

            int x_min = i;
            int x_max = i;
            int y_min = j;
            int y_max = j;

            tmp[i][j] = true;
            arr[i][j] = (mode + 1) % 2;
            q.add(new Node(i, j));

            while(!q.isEmpty()) {
                Node cur = q.poll();
                int x = cur.x;
                int y = cur.y;

                x_min = Math.min(x_min, x);
                x_max = Math.max(x_max, x);
                y_min = Math.min(y_min, y);
                y_max = Math.max(y_max, y);

                for(int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];

                    if(!isBoundary(nx, ny)) continue;

                    if(arr[nx][ny] == mode) {
                        tmp[nx][ny] = true;
                        arr[nx][ny] = (mode + 1) % 2;
                        q.add(new Node(nx, ny));
                    }
                }
            }

            for(int x = x_min; x <= x_max; x++) {
                for(int y = y_min; y <= y_max; y++) {
                    s += tmp[x][y] ? "1" : "0";
                }
                s += " ";
            }

            return s;
        }

        public boolean isBoundary(int x, int y) {
            return x >= 0 && x < N && y >= 0 && y < N;
        }
    }
}
