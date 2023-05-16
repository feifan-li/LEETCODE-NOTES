package BinarySearch.LC154FindMinInRotatedSortedArrayII;

public class Solution154 {
    public int findMin(int[] nums) {
        int n = nums.length;
        if(n==1 || nums[n-1]>nums[0]) return nums[0];
        int left = 0;
        int right = n-1;
        //note that min element is in right sorted array
        while(left<right){
            int mid = left+(right-left)/2;
            if(nums[mid]>nums[right]){//in left sorted array
                left = mid+1;//one day left will jump to right sorted array
            }else if(nums[mid]<nums[right]){//in right sorted array
                right = mid;//should not be possible to jump to left sorted array
            }else{
                right--;
            }
        }
        return nums[left];
    }
}
