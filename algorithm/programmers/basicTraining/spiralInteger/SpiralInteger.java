package programmers.basicTraining.spiralInteger;

// 정수를 나선형으로 배치하기
// 양의 정수 n이 매개변수로 주어집니다. n × n 배열에 1부터 n2 까지 정수를
// 인덱스 [0][0]부터 시계방향 나선형으로 배치한 이차원 배열을 return 하는 solution
// 함수를 작성해 주세요.

public class SpiralInteger {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];

        int dir = 0;
        int x = 0, y = 0;
        int cnt = 0;

        for (int i = 1; i <= (n * n); i++) {
            answer[x][y] = i;

            if ((dir % 4) == 0) {
                y++;
                if (y == n - (1 + cnt)) {
                    dir++;
                }
            } else if ((dir % 4) == 1) {
                x++;
                if (x == n - (1 + cnt)) {
                    dir++;
                }
            } else if ((dir % 4) == 2) {
                y--;
                if (y == (0 + cnt)) {
                    dir++;
                    cnt++;
                }
            } else if ((dir % 4) == 3) {
                x--;
                if (x == (0 + cnt)){
                    dir++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        SpiralInteger task = new SpiralInteger();
        int n = 4;

        int[][] result = task.solution(n);

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

    }
}
