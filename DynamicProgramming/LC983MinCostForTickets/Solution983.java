package DynamicProgramming.LC983MinCostForTickets;

public class Solution983 {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int pass[] = new int[]{1,7,30};
        int[] dp = new int[n+1];//dp[i]:min cost travel from day i to last day
        dp[n-1] = Math.min(costs[0],Math.min(costs[1],costs[2]));
        for(int i=n-2;i>=0;--i){
            int j = i+1;
            dp[i] = dp[j]+costs[0];
            while(j<n && days[i]+6>=days[j]) j++;
            dp[i] = Math.min(dp[i],dp[j]+costs[1]);
            while(j<n && days[i]+29>=days[j]) j++;
            dp[i] = Math.min(dp[i],dp[j]+costs[2]);
        }
        return dp[0];
    }
}
