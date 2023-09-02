package LC15_3Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution15 {
    public List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length && nums[i]<=0;++i){
            if(i==0 || nums[i]!=nums[i-1])  twoSum(nums,i);
        }
        return ans;
    }
    public void twoSum(int[] nums,int i){
        int l = i+1, r = nums.length-1;
        while(l<r){
            if(nums[i]+nums[l]+nums[r]==0){
                ans.add(Arrays.asList(nums[i],nums[l++],nums[r--]));
                while(l<r && nums[l]==nums[l-1])    l++;
                while(l<r && (r==nums.length-1 || nums[r]==nums[r+1]))    r--;
            }
            else if(nums[i]+nums[l]+nums[r]<0) l++;
            else if(nums[i]+nums[l]+nums[r]>0) r--;
        }
    }
}
