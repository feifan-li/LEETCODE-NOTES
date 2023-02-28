package LC81SearchInRotatedSortedArrayII;

public class Solution81 {
    public static boolean search(int[] nums, int target) {
        int n = nums.length;
        if(n==1) return nums[0]==target;
        int left = 0;
        int right = n-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid]==target) return true;
            if(nums[left]<nums[mid]){
                if(nums[left]<=target && target<nums[mid]){
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
        return false;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{1,0,1,1,1},0));
        System.out.println(search(new int[]{1,1,1,1,1,1,1,1,1,13,1,1,1,1,1,1,1,1,1,1,1,1},13));
        System.out.println(search(new int[]{2,5,6,0,0,1,2},3));
    }
}
