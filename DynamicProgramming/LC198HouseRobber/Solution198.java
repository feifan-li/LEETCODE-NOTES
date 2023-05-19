package DynamicProgramming.LC198HouseRobber;

public class Solution198 {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+2];
        for(int i=n-1;i>=0;--i){
            dp[i] = Math.max(dp[i+2]+nums[i],dp[i+1]);
        }
        return dp[0];
    }
}
