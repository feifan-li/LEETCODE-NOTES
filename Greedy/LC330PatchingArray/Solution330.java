package Greedy.LC330PatchingArray;

public class Solution330 {
    public int minPatches(int[] nums, int n) {
        long miss = 1;//[1,miss-1] is coverd
        int patches = 0, i = 0;//# of patches needed
        while(miss<=n){
            if(i<nums.length && nums[i]<=miss){
                miss += nums[i++];//patch nums[i], now [1,miss-1]+[nums[i],nums[i]+miss-1] = [1,nums[i]+miss-1] is covered
            }else{
                miss = miss<<1;//patch miss itself, now [1,2*miss-1] is covered, else miss is forever missed since nums is sorted
                patches++;
            }
        }
        return patches;
    }
}
