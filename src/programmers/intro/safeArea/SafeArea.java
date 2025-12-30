package programmers.intro.safeArea;

// 안전지대

// board는 n * n 배열입니다.
// 1 ≤ n ≤ 100
// 지뢰는 1로 표시되어 있습니다.
// board 에는 지뢰가 있는 지역 1과 지뢰가 없는 지역 0만 존재합니다.

// [[0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 1, 0, 0], [0, 0, 0, 0, 0]]	16
// [[0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 1, 1, 0], [0, 0, 0, 0, 0]]	13
// [[1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 1, 1]]	0

public class SafeArea {

    public int solution(int[][] board) {
        int size = board.length;
        int answer = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                if(board[i][j] == 1){

                    for (int dx = -1; dx < 2; dx++) {
                        for (int dy = -1; dy < 2; dy++) {
                            if(dx == 0 && dy == 0){
                                continue;
                            }
                            int x = i + dx;
                            int y = j + dy;

                            if ((x >= 0 && x < size) && ((y >= 0) && (y < size)) && (board[x][y] != 1)) {
                                board[x][y] = -1;
                            }
                        }
                    }

                }

            }
        }

        for (int[] ints : board) {
            for (int j = 0; j < size; j++) {
                if (ints[j] == 0) {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        SafeArea task = new SafeArea();
        int[][] board = 	{{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 1, 0}, {0, 0, 0, 0, 0}};

        System.out.println(task.solution(board));
    }

}
