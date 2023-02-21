package TreeDP.LC1928MinCostReachDestinationinTime;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution1928 {
    public int minCost(int maxTime, int[][] edges, int[] fee) {
        ArrayList<ArrayList<int[]>> graph = new ArrayList<ArrayList<int[]>>();
        int n = fee.length;
        for(int i=0;i<n;++i) graph.add(new ArrayList<int[]>());
        for(int[] e:edges){
            graph.get(e[0]).add(new int[]{e[1],e[2]});
            graph.get(e[1]).add(new int[]{e[0],e[2]});
        }
        int inf = 0x3f3f3f3f;
        int[][] dp = new int[maxTime+1][n];//dp[i][j]:min fees from 0 to j with total time=i
        for(int i=0;i<dp.length;++i) Arrays.fill(dp[i],inf);
        dp[0][0] = fee[0];

        int ans = Integer.MAX_VALUE;
        for(int i=0;i<=maxTime;++i){
            for(int v=0;v<n;++v){
                for(int[] e:graph.get(v)){
                    if(e[1]<=i){
                        dp[i][v] = Math.min(dp[i][v],dp[i-e[1]][e[0]]+fee[v]);
                    }
                }
            }
            ans = Math.min(ans,dp[i][n-1]);
        }
        return ans>=inf?-1:ans;
    }
}
