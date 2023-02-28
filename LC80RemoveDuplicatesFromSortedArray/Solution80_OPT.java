package LC80RemoveDuplicatesFromSortedArray;

import java.util.HashMap;

public class Solution80_OPT {
    public static int removeDuplicates(int[] nums) {
        if(nums.length<=2) return nums.length;
        int newIndex = 2;
        for(int i=2;i<nums.length;++i){
            if(nums[i]!=nums[newIndex-2]){
                nums[newIndex++] = nums[i];
            }
        }
        return newIndex;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1,1,1,2,2,3}));
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3}));
    }
}
