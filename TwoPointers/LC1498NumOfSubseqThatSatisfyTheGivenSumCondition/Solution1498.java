package TwoPointers.LC1498NumOfSubseqThatSatisfyTheGivenSumCondition;

import java.util.Arrays;

public class Solution1498 {
    public int numSubseq(int[] nums, int target) {
        final int MOD = 1000000007;
        Arrays.sort(nums);
        int ans = 0;
        int[] power2 = new int[nums.length];//avoid int/long overflow
        power2[0] = 1;
        for(int i=1;i<nums.length;++i)  power2[i] = (power2[i-1]<<1)%MOD;
        //two pointers
        int left = 0,right = nums.length-1;
        while(left<=right){
            if(nums[left]+nums[right]<=target){
                ans = (ans+power2[right-left])%MOD;
                left++;
            }else right--;
        }
        return ans;
    }
}
