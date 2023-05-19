package JavaBasics.LC189RotateArray;

public class Solution189_2 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        if(k==0) return;
        int[] nums2 = nums.clone();
        int j = n-k;
        for(int i=0;i<n;++i){
            nums[i] = nums2[j];
            j = (j+1)%n;
        }
    }
}
