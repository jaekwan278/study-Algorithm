package programmers.kakao.friends4Block;

// 프렌즈4블록

import java.util.HashSet;
import java.util.Set;

public class Friends4Block {

    private char[][] makeBoard(int m, int n, String[] board) {
        char[][] result = new char[n][m];

        for (int w = 0; w < n; w++) {
            for (int h = m - 1; h >= 0; h--) {
                result[w][m - (h + 1)] = board[h].charAt(w);
            }
        }

        return result;
    }

    private int replaceValidChar(char[][] board, Set<String> dupSet, int w, int h) {
        int cnt = 0;

        for (int i = 0; i < w - 1; i++) {
            for (int j = 0; j < h - 1; j++) {

                char lt = board[i][j];
                if (lt == '.') continue;

                char rt = board[i][j + 1];
                char lb = board[i + 1][j];
                char rb = board[i + 1][j + 1];

                if (lt == rt && rt == lb && lb == rb) {
                    dupSet.add(i + "," + j);
                    dupSet.add(i + "," + (j + 1));
                    dupSet.add((i + 1) + "," + j);
                    dupSet.add((i + 1) + "," + (j + 1));
                }
            }
        }

        if (!dupSet.isEmpty()) {
            for (String str : dupSet) {
                String[] pt = str.split(",");
                int p1 = Integer.parseInt(pt[0]);
                int p2 = Integer.parseInt(pt[1]);

                board[p1][p2] = '.';
                cnt++;
            }
        }

        return cnt;
    }

    private void sortBoard(char[][] board, int w, int h) {

        for (int i = 0; i < w; i++) {

            int idx = 0;
            for (int j = 0; j < h; j++) {

                if (board[i][j] != '.') {
                    board[i][idx] = board[i][j];

                    if(idx != j){
                        board[i][j] = '.';
                    }
                    idx++;
                }
            }
        }

    }

    public int solution(int m, int n, String[] board) {
        int answer = 0;

        char[][] chArr = makeBoard(m, n, board);

        int cnt;
        do {
            Set<String> dupSet = new HashSet<>();

            cnt = replaceValidChar(chArr, dupSet, n, m);

            sortBoard(chArr, n, m);

            answer += cnt;

        } while (cnt > 0);

        return answer;
    }

    public static void main(String[] args) {
        Friends4Block task = new Friends4Block();

        int m = 4, n = 5;
        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};

        System.out.println(task.solution(m, n, board));
    }

}
/*
    CCBDE
    AAADE
    AAABF
    CCBBF
 */
