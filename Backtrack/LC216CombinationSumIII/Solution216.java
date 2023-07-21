package Backtrack.LC216CombinationSumIII;

import java.util.ArrayList;
import java.util.List;

public class Solution216 {
    public List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9};
        if(n>45 || n<3 || (k==9 && n!=45))    return res;
        backtrack(nums,k,n,new ArrayList<Integer>(),0);
        return res;
    }
    public void backtrack(int[] nums,int targetLen, int target, ArrayList<Integer> list,int start){
        if(target==0 && targetLen==list.size()){
            res.add(new ArrayList<>(list));
            return;
        }else if(target<0 || list.size()>=targetLen){
            return;
        }
        for(int i=start;i<nums.length;++i){
            list.add(nums[i]);
            backtrack(nums,targetLen,target-nums[i],list,i+1);
            list.remove(list.size()-1);
        }
    }
}
