package LC259_3SumSmaller;

import java.util.Arrays;

public class Solution259 {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        for(int i=0;i<nums.length-2;++i){
            int left = i+1, right = nums.length-1;
            while(left<right){
                if(nums[i]+nums[left]+nums[right] < target) {
                    res += right-left;//[i,left,left+1],[i,left,left+1],...,[i,left,right]
                    left++;
                }else{
                    right--;
                }
            }
        }
        return res;
    }
}
