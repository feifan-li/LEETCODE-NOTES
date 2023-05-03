package Backtrack.LC90SubsetsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //backtrack
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        helper(ans,cur,nums,0);
        return ans;
    }
    private void helper(List<List<Integer>> ans,List<Integer> cur,int[] nums,int start){
        ans.add(new ArrayList<>(cur));
        for(int i=start;i<nums.length;++i){
            if(i!=start && nums[i]==nums[i-1])  continue;
            cur.add(nums[i]);
            helper(ans,cur,nums,i+1);
            cur.remove(cur.size()-1);
        }
    }
}
