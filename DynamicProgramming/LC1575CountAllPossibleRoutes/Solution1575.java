package DynamicProgramming.LC1575CountAllPossibleRoutes;

import java.util.Arrays;

public class Solution1575 {
    public final int MOD = 1_000_000_007;
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int n = locations.length;
        int[][] dp = new int[n][fuel+1]; //dp[i][j]: # of routes from i to finish use no more than j fuel
        Arrays.fill(dp[finish],1);//base case
        for(int j=0;j<=fuel;++j){
            for(int i=0;i<n;++i){
                for(int k=0;k<n;++k){
                    int d = Math.abs(locations[i]-locations[k]);
                    if(k!=i && d<=j)    dp[i][j] = (dp[i][j]+dp[k][j-d])%MOD;
                }
            }
        }
        return dp[start][fuel];
    }
}
