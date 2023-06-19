package DynamicProgramming.LC265PaintHouseII;

import java.util.Arrays;

public class Solution265 {
    public int minCostII(int[][] costs) {
        int n = costs.length;
        int k = costs[0].length;
        int[] dp = new int[k];
        for(int c=0;c<k;++c)    dp[c] = costs[0][c];
        for(int i=1;i<n;++i){
            int[] dp_prev = Arrays.copyOf(dp,dp.length);
            for(int c=0;c<k;++c){
                int min = Integer.MAX_VALUE;
                for(int cprev = 0;cprev<k;++cprev){
                    if(cprev!=c) min = Math.min(min,dp_prev[cprev]);
                }
                dp[c] = costs[i][c] + min;
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int c=0;c<k;++c)    ans = Math.min(ans,dp[c]);
        return ans;
    }
}
