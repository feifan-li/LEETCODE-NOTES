package BinarySearch.LC287FindTheDuplicateNumber;

public class Solution287_2 {
    /*Negative Marking*/
    //cannot use XOR since input may be like : [2,2,2,2,2]
    /*Time Compexity: O(n)*/
    /*Space Complexity: O(1)*/
    public int findDuplicate(int[] nums) {
        int dup = -1;
        for(int num:nums){
            dup = nums[Math.abs(num)]<0?Math.abs(num):-1;
            if(dup>0)   break;
            nums[Math.abs(num)] *= -1;
        }
        for(int i=0;i<nums.length;++i)  nums[i] = Math.abs(nums[i]);
        return dup;
    }
}
