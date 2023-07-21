package DynamicProgramming.LongestIncreasingSubsequence.LC673NumberOfLIS;

import java.util.Arrays;

public class Solution673 {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];//dp[i]: length of LIS ending with nums[i]
        int[] cnt = new int[n];//cnt[i]: number of LIS ending with nums[i]
        Arrays.fill(dp,1);
        Arrays.fill(cnt,1);
        for(int i=0;i<n;++i){
            for(int j=0;j<i;++j){
                if(nums[j]<nums[i]){
                    if(dp[j]+1 > dp[i]){
                        dp[i] = dp[j]+1;
                        cnt[i] = cnt[j];
                    }else if(dp[j]+1==dp[i]){
                        cnt[i] = cnt[i]+cnt[j];
                    }
                }
            }
        }
        int maxLen = 0, ans =0;
        for(int i=0;i<n;++i)    maxLen = Math.max(maxLen,dp[i]);
        for(int i=0;i<n;++i)    ans = ans + (dp[i]==maxLen?cnt[i]:0);
        return ans;
    }
}
