package LC324WiggleSortII;

import java.util.Arrays;

public class Solution324 {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] tmp = new int[nums.length];
        int odd = (nums.length - 1)/2, even = nums.length-1;
        for(int i=0;i<nums.length;++i){
            if((i&1)==1)  tmp[i] = nums[even--];
            else tmp[i] = nums[odd--];
        }
        System.arraycopy(tmp,0,nums,0,nums.length);
    }
}
