package DynamicProgramming.LC746MinCostClimbingStairs;

public class Solution746 {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;//top = n+1
        int dp_0 = cost[0],dp_1 = cost[1],dp_2 = 0;
        for(int i=2;i<n;++i){
            dp_2 = Math.min(dp_0,dp_1)+cost[i];
            dp_0 = dp_1;
            dp_1 = dp_2;
        }
        return Math.min(dp_0,dp_1);
    }
}
