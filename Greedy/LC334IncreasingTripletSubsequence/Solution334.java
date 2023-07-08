package Greedy.LC334IncreasingTripletSubsequence;

public class Solution334 {
    public boolean increasingTriplet(int[] nums) {
        int i = nums[0];
        int j = Integer.MAX_VALUE;
        for(int k : nums){
            if(k>j) return true;
            else if(k>i) j=k;
            else if(k <= i) i=k;
        }
        return false;
    }
}
