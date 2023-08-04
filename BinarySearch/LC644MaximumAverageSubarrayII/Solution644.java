package BinarySearch.LC644MaximumAverageSubarrayII;

import java.util.Arrays;

public class Solution644 {
    public double findMaxAverage(int[] nums, int k) {
        double avgL = (double)(Arrays.stream(nums).min().getAsInt());
        double avgR = (double)(Arrays.stream(nums).max().getAsInt());
        double error = avgR-avgL, avgMax = avgL;
        while(avgR-avgL>=0.00001){
            double avgMid = avgL*0.5+avgR*0.5;
            if(check(nums,avgMid,k)){
                avgMax = Math.max(avgMax,avgMid);
                avgL = avgMid;
            }else{
                avgR = avgMid;
            }
        }
        return avgMax;
    }
    public boolean check(int[] nums, double avg, int k){
        //check是否存在长度>=k的子数组的平均值>=avg
        double sum = 0.0, prefixSum = 0.0, minPrefixSum = 0.0;
        for(int i=0;i<k;++i)    sum += nums[i]-avg;
        if(sum>=0)  return true;
        for(int i=k;i<nums.length;++i){
            sum += nums[i]-avg;
            prefixSum += nums[i-k]-avg;//sum-prefixSum = nums[i]+nums[i-1]+...+nums[i-k-1] - avg*k
            minPrefixSum = Math.min(minPrefixSum,prefixSum);
            if(sum-minPrefixSum>=0) return true;
        }
        return false;
    }
}
