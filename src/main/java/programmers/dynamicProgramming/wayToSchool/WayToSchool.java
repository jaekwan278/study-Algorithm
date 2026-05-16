package programmers.dynamicProgramming.wayToSchool;

// 등굣길

import utils.Compare;

public class WayToSchool {

    public int solution(int m, int n, int[][] puddles) {

        int[] dp = new int[m];
        dp[0] = 1;

        boolean[][] block = new boolean[n][m];
        for(int[] p : puddles){
            block[p[1]-1][p[0]-1] = true;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){

                if(block[i][j]){
                    dp[j] = 0;

                }else if(j > 0){
                    dp[j] = dp[j-1] % 1_000_000_007 + dp[j] % 1_000_000_007;

                }

            }
        }

        return dp[m-1];
    }

    public int solution2(int m, int n, int[][] puddles) {
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<puddles.length;i++){
            dp[puddles[i][0]][puddles[i][1]]=-1;
        }
        dp[1][1]=1;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(dp[i][j]==-1){
                    dp[i][j]=0;
                    continue;
                }
                if(i!=1)    dp[i][j]+=dp[i-1][j]%1000000007;
                if(j!=1)    dp[i][j]+=dp[i][j-1]%1000000007;
            }
        }
        return dp[m][n]%1000000007;
    }


    public static void main(String[] args) {
        WayToSchool task = new WayToSchool();
        int m = 50, n = 47;
        int[][] puddles = new int[][]{{2,2}, {4, 5}, {22, 31}, {30, 42}};

        System.out.println(task.solution(m, n, puddles));

        Compare.measureTime(()->task.solution(m, n, puddles), ()->task.solution2(m, n, puddles));
    }
}
