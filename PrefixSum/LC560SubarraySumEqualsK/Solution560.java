package PrefixSum.LC560SubarraySumEqualsK;

import java.util.HashMap;

public class Solution560 {
    public int subarraySum(int[] nums, int k) {
        int[] sum = new int[nums.length];
        HashMap<Integer,Integer> sumCount = new HashMap<>();
        sumCount.put(0,1);
        int ans = 0;
        for(int i=0;i<nums.length;++i){
            sum[i] = nums[i]+(i>0?sum[i-1]:0);
            ans += sumCount.getOrDefault(sum[i]-k,0);
            sumCount.put(sum[i],sumCount.getOrDefault(sum[i],0)+1);
        }
        return ans;
    }
}
