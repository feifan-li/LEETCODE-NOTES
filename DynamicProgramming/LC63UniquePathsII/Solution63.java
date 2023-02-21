package DynamicProgramming.LC63UniquePathsII;

public class Solution63 {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[0][0]==1 || obstacleGrid[m-1][n-1]==1) return 0;
        int[][] dp = new int[m][n];
        //base case:
        dp[m-1][n-1] = 1;
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                if(obstacleGrid[i][j]==1) dp[i][j] = 0;
            }
        }
        //dp:
        for(int j=n-2;j>=0;--j){
            if(obstacleGrid[m-1][j]==1) continue;
            else dp[m-1][j] = dp[m-1][j+1];
        }
        for(int i=m-2;i>=0;--i){
            if(obstacleGrid[i][n-1]==1) continue;
            else dp[i][n-1] = dp[i+1][n-1];
        }
        for(int i=m-2;i>=0;--i){
            for(int j=n-2;j>=0;--j){
                if(obstacleGrid[i][j]!=1){
                    dp[i][j] = dp[i+1][j]+dp[i][j+1];
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {

    }
}
