package DynamicProgramming.LC1493LongestSubarrayof1sAfterDeletingOneElement;

public class Solution1493 {
    public int longestSubarray(int[] nums) {
        int[] dp1 = new int[nums.length];//length of consecutive 1s ending with nums[i]
        int[] dp2 = new int[nums.length];//length of consecutive 1s starting with nums[i]
        dp1[0] = nums[0];//base case dp1
        dp2[nums.length-1] = nums[nums.length-1];//base case dp2
        for(int i=1;i<nums.length;++i)  dp1[i] = (nums[i]==0?0:dp1[i-1]+1);
        for(int i=nums.length-2;i>=0;--i)   dp2[i] = (nums[i]==0?0:dp2[i+1]+1);
        int max = Math.max(dp2[1],dp1[nums.length-2]);
        for(int i=1;i<nums.length-1;++i)    max = Math.max(max,dp1[i-1]+dp2[i+1]);
        return max;
    }
}
