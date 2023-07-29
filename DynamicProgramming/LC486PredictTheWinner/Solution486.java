package DynamicProgramming.LC486PredictTheWinner;

public class Solution486 {
    public boolean PredictTheWinner(int[] nums) {
        if(nums.length<=2)  return true;
        int[][] dp = new int[nums.length][nums.length];
        for(int l=0;l<nums.length;++l)  dp[l][l] = nums[l];
        for(int r=1;r<nums.length;++r){
            for(int l=r-1;l>=0;--l){
                dp[l][r] = Math.max(nums[l]-dp[l+1][r],nums[r]-dp[l][r-1]);
            }
        }
        return dp[0][nums.length-1]>=0;
    }
}
