package LC2966DivideArrayIntoArraysWithMaxDifference;

import java.util.Arrays;

public class Solution2966 {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        int[][] ans = new int[n/3][3];
        Arrays.sort(nums);
        for(int i=0;i<n;i = i+3){
            if(nums[i+2] - nums[i] <= k){
                ans[i/3][0] = nums[i];
                ans[i/3][1] = nums[i+1];
                ans[i/3][2] = nums[i+2];
            }else{
                return new int[0][0];
            }
        }
        return ans;
    }
}
