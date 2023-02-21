package DynamicProgramming.LC152MaxProductSubarray;

public class Solution152 {
    //A subarray is a contiguous non-empty sequence of elements within an array.
    //dynamic programming
    public static int maxProduct(int[] nums) {
        int ans = nums[0];
        int min = nums[0];//the product of subarray[0,0] that has the min product;
        int max = nums[0];//the product of subarray[0,0] that has the max product;
        //dp: we check max-product & min-product subarrays ending with each index
        for(int i=1;i<nums.length;++i){
            //the product of subarray ending with i that has the min product;
            int curMin = Math.min(nums[i],Math.min(min*nums[i],max*nums[i]));
            //the product of subarray ending with i that has the max product;
            int curMax = Math.max(nums[i],Math.max(min*nums[i],max*nums[i]));
            min = curMin;
            max = curMax;
            ans = Math.max(ans,max);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2,3,-2,4}));
        System.out.println(maxProduct(new int[]{-2,0,-1}));
    }
}
