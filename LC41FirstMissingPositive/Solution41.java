package LC41FirstMissingPositive;

public class Solution41 {
    public static int firstMissingPositive(int[] nums) {
        //move all positive <= nums.length to nums[positive-1] by swapping
        for(int i=0;i<nums.length;++i){
            while(nums[i]>0 && nums[i]<= nums.length && nums[i]!=nums[nums[i]-1]){
                //swap nums[i] and nums[nums[i]-1]
                int tmp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = tmp;
            }
        }
        for(int i=0;i<nums.length;++i){
            if(nums[i]!=i+1) return i+1;
        }
        return nums.length+1;
    }

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{1,2,0}));
        System.out.println(firstMissingPositive(new int[]{3,4,-1,1}));
        System.out.println(firstMissingPositive(new int[]{7,8,9,11,12}));
        System.out.println(firstMissingPositive(new int[]{1,2,3}));
    }
}
