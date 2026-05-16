package programmers.dynamicProgramming.integerTriangle;

// 정수 삼각형

public class IntegerTriangle {

    public int solution(int[][] triangle) {
        int answer = 0;

        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];

        for(int i = 1; i < triangle.length; i++){

            for(int j = 0; j <= i; j++){
                int left = (j-1) < 0 ? dp[i-1][0] : dp[i-1][j-1];
                int right = j == i ? dp[i-1][j-1] : dp[i-1][j];

                dp[i][j] = triangle[i][j] + Math.max(left, right);
            }

        }

        for(int n : dp[triangle.length-1]){
            answer = Math.max(answer, n);
        }

        return answer;
    }

    public static void main(String[] args) {
        IntegerTriangle task = new IntegerTriangle();
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};

        System.out.println(task.solution(triangle));
    }

}
