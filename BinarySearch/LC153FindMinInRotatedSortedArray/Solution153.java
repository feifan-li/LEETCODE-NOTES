package BinarySearch.LC153FindMinInRotatedSortedArray;

public class Solution153 {
    public int findMin(int[] nums) {
        int n = nums.length;
        //single num case , sorted unrotated case
        if(n==1 || nums[n-1]>nums[0]) return nums[0];
        //rotated sorted case: binary search
        int left = 0, right = n-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]>nums[mid+1])   return nums[mid+1];
            if(nums[mid]<nums[mid-1])   return nums[mid];
            if(nums[mid]>=nums[0]){//mid in left sorted side
                left = mid+1;
            }else{//mid in right sorted side
                right = mid-1;
            }
        }
        return 99999;//can never reach here
    }
}
