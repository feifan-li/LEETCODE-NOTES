package LC540SingleElementInASortedArray;

public class Solution540 {
    public static int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n-1;
        while(left!=right){
            int mid = left+(right-left)/2;
            if(mid%2!=0){
                if(nums[mid]==nums[mid-1]){
                    left = mid+1;
                }else{
                    if(nums[mid]!=nums[mid+1]) return nums[mid];
                    right = mid-1;
                }
            }else if(mid%2==0){
                if(nums[mid]==nums[mid+1]){
                    left = mid+2;
                }else{
                    if(nums[mid]!=nums[mid-1]) return nums[mid];
                    right = mid-2;
                }
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        System.out.println(singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8}));
        System.out.println(singleNonDuplicate(new int[]{3,3,7,7,10,11,11}));
    }
}
