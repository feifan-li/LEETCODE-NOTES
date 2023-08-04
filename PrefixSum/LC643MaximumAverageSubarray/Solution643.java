package PrefixSum.LC643MaximumAverageSubarray;

public class Solution643 {
    public double findMaxAverage(int[] nums, int k) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for(int i=1;i<nums.length;++i)  sum[i] = sum[i-1]+nums[i];
        int kSumMax = sum[k-1];
        for(int i=1;i<nums.length-k+1;++i){
            int cur = sum[i+k-1]-sum[i-1];
            kSumMax = Math.max(kSumMax,cur);
        }
        return (double)kSumMax/(double)k;
    }
}
