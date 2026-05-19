package programmers.basicTraining.diagonalTraversal2D;

// 이차원 배열 대각선 순회하기

import utils.Compare;

public class DiagonalTraversal2D {

    public int solution(int[][] board, int k) {
        int answer = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if((i + j) <= k) answer += board[i][j];
            }
        }

        return answer;
    }

    public int solution2(int[][] board, int k){
        int answer = 0;
        for(int i = 0; i <= k; i++){
            for(int j = 0; j <= (k - i); j++){
                answer += board[i][j];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        DiagonalTraversal2D task = new DiagonalTraversal2D();
        int[][] board = {{0, 1, 2},{1, 2, 3},{2, 3, 4},{3, 4, 5}};
        int k = 2;

        System.out.println(task.solution2(board, k));

        Compare.measureTime(()->task.solution(board, k), ()->task.solution2(board,k));
    }

}
