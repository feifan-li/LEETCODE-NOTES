package DynamicProgramming.LC2304MinPathCostInAGrid;

public class Solution2304 {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length;
        int n = grid[0].length;
        //int[][] dp = new int[m][n];//dp[i][j]: min cost from grid[i][j] to last row
        //for(int col=0;col<n;++col){
        //    dp[m-1][col] = grid[m-1][col];
        //}
        for(int row=m-2;row>=0;--row){
            for(int col=0;col<n;++col){
                int val = grid[row][col];
                int choice = Integer.MAX_VALUE;
                for(int k=0;k<n;++k){
                    //choice = Math.min(choice,dp[row+1][k]+moveCost[val][k]);
                    choice = Math.min(choice,grid[row+1][k]+moveCost[val][k]);
                }
                //dp[row][col] = choice+val;
                grid[row][col] += choice;
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int col=0;col<n;++col)  ans = Math.min(ans,grid[0][col]);
        return ans;
    }
}
