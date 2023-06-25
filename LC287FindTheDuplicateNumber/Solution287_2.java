package LC287FindTheDuplicateNumber;

public class Solution287_2 {
    /*Negative Marking*/
    /*Time Compexity: O(n)*/
    /*Space Complexity: O(1)*/
    public int findDuplicate(int[] nums) {
        int dup = -1;
        for(int num:nums){
            if(nums[Math.abs(num)]<0){
                dup = Math.abs(num);
                break;
            }
            nums[Math.abs(num)] *= -1;
        }
        for(int i=0;i<nums.length;++i){
            nums[i] = Math.abs(nums[i]);
        }
        return dup;
    }
}
