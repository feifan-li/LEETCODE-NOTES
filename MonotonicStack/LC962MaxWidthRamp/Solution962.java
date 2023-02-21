package MonotonicStack.LC962MaxWidthRamp;

import java.util.Stack;

//A ramp in an integer array nums is a pair (i, j) for which i < j and nums[i] <= nums[j]. The width of such a ramp is j - i.
//Given an integer array nums, return the maximum width of a ramp in nums. If there is no ramp in nums, return 0.
public class Solution962 {
    public static int maxWidthRamp(int[] nums){
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i=1;i<nums.length;++i){
            if(nums[i]<nums[stack.peek()]) stack.push(i);
        }
        int ans=0;
        for(int j=nums.length-1;j>=0;--j){
            while(!stack.isEmpty() && nums[j]>=nums[stack.peek()]){
                int i = stack.pop();
                ans = Math.max(ans,j-i);//if i>=j ans = 0
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{6,0,8,2,1,5};
        int[] nums2 = new int[]{9,8,1,0,1,9,4,0,4,1};
        int[] nums3 = new int[]{2,1};
        System.out.println(maxWidthRamp(nums1));
        System.out.println(maxWidthRamp(nums2));
        System.out.println(maxWidthRamp(nums3));
    }
}
