package DynamicProgramming.LC63UniquePathsII;

public class Solution63 {
    public static int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if(grid[0][0]==1 || grid[m-1][n-1]==1) return 0;
        int[][] dp = new int[m][n];
        //base cases:
        dp[m-1][n-1] = 1;
        for(int j=n-2;j>=0;--j){
            if(grid[m-1][j]!=1) dp[m-1][j] = dp[m-1][j+1];
        }
        for(int i=m-2;i>=0;--i){
            if(grid[i][n-1]!=1) dp[i][n-1] = dp[i+1][n-1];
        }
        //dp:
        for(int i=m-2;i>=0;--i){
            for(int j=n-2;j>=0;--j){
                if(grid[i][j]!=1)   dp[i][j] = dp[i+1][j]+dp[i][j+1];
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {

    }
}
