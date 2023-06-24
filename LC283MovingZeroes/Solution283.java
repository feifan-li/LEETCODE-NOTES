package LC283MovingZeroes;

public class Solution283 {
    public void moveZeroes(int[] nums) {
        if(nums.length==1)  return;
        int i=0,p=1;
        while(i<nums.length){
            while(i<nums.length && nums[i]!=0)    i++;
            if(i==nums.length)  return;
            p = Math.max(p,i+1);
            while(p<nums.length && nums[p]==0)    p++;
            if(p==nums.length)  return;
            int tmp = nums[i];
            nums[i] = nums[p];
            nums[p] = tmp;
            i++;
        }
    }
}
