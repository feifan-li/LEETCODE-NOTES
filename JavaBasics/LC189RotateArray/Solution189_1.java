package JavaBasics.LC189RotateArray;

public class Solution189_1 {
    public void rotate(int[] nums, int k) {
        //O(1) space complexity solution
        int n = nums.length;
        k %= n;
        if(k==0) return;
        //first reverse entire int[]
        for(int i=0;i<n/2;++i){
            int tmp = nums[i];
            nums[i] = nums[n-1-i];
            nums[n-1-i] = tmp;
        }
        //reverse first part
        for(int i=0;i<k/2;++i){
            int tmp = nums[i];
            nums[i] = nums[k-1-i];
            nums[k-1-i] = tmp;
        }
        //reverse second part
        for(int i=0;i<(n-k)/2;++i){
            int tmp = nums[k+i];
            nums[k+i] = nums[n-1-i];
            nums[n-1-i] = tmp;
        }
    }
}
