package DynamicProgramming.LC120Triangle;

import java.util.List;

public class Solution120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        for(int row=1;row<n;++row){
            for(int col=0;col<=row;++col){
                if(col==0) dp[row][col] = triangle.get(row).get(col)+dp[row-1][col];
                else if(col==row) dp[row][col] = triangle.get(row).get(col)+dp[row-1][col-1];
                else dp[row][col] = triangle.get(row).get(col) + Math.min(dp[row-1][col], dp[row-1][col-1]);
            }
        }
        int ans = dp[n-1][0];
        for(int i=1;i<n;++i)    ans = Math.min(ans,dp[n-1][i]);
        return ans;
    }
}
