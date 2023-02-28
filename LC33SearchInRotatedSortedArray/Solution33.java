package LC33SearchInRotatedSortedArray;

public class Solution33 {
    //must be O(log(n))
    public static int search(int[] nums, int target) {
        int n = nums.length;
        if(n==1) return nums[0]==target?0:-1;
        int left = 0;
        int right = n-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid]==target) return mid;
            if(nums[left]<nums[mid]){
                if(nums[left]<=target && nums[mid]>target){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }else if(nums[left]>nums[mid]){
                if(nums[mid]<target && target<=nums[right]){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }else{
                left++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{4,5,6,7,0,1,2},0));
    }
}
