package DynamicProgramming.LC64MinPathSum;

public class Solution64 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = grid[m-1][n-1];
        for(int row = m-2;row>=0;row--){
            dp[row][n-1] = grid[row][n-1]+dp[row+1][n-1];
        }
        for(int col = n-2;col>=0;col--){
            dp[m-1][col] = grid[m-1][col]+dp[m-1][col+1];
        }
        if(m==1 || n==1) return dp[0][0];
        for(int row = m-2;row>=0;--row){
            for(int col = n-2;col>=0;--col){
                dp[row][col] = grid[row][col] + Math.min(dp[row][col+1],dp[row+1][col]);
            }
        }
        return dp[0][0];
    }
}
