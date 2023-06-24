package Greedy.LC280WiggleSort;

public class Solution280 {
    public void wiggleSort(int[] nums) {
        //Goal: odd index is local max, even index is local min
        //Greedy: inc a val at odd index or dec a val at even index won't affect the overall correctness
        for(int i=1;i<nums.length;++i){
            if((i%2==1 && nums[i]<nums[i-1]) || (i%2==0 && nums[i]>nums[i-1])){
                int tmp = nums[i-1];
                nums[i-1] = nums[i];
                nums[i] = tmp;
            }
        }
    }
}
