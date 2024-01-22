package LC645SetMismatch;

import java.util.Arrays;

public class Solution645 {
    public int[] findErrorNums(int[] nums) {
        int delta = (1+nums.length)*nums.length/2;
        for(int num:nums){
            delta -= num;
        }
        Arrays.sort(nums);
        int x = 0;
        for(int i=0;i<nums.length-1;++i){
            if(nums[i]==nums[i+1]){
                x = nums[i];
                break;
            }
        }
        return new int[]{x,x+delta};
    }
}
