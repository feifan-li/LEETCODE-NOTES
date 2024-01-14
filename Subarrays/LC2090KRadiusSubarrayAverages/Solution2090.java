package Subarrays.LC2090KRadiusSubarrayAverages;

import java.util.Arrays;

public class Solution2090 {
    public int[] getAverages(int[] nums, int k) {
        long sum = 0;
        for(int i=0;i<Math.min(nums.length,2*k+1);++i)  sum += nums[i];
        int[] ans = new int[nums.length];
        Arrays.fill(ans,-1);
        for(int i=k;i<=nums.length-1-k;++i){
            sum = sum - (i==k?0:nums[i-k-1]) + (i==k?0:nums[i+k]);
            ans[i] = (int)(sum/(2*k+1));
        }
        return ans;
    }
}
