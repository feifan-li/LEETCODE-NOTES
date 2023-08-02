package Backtrack.LC47PermutationsII;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution47 {
    List<List<Integer>> ans = new LinkedList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums,new boolean[nums.length], new LinkedList<>());
        return ans;
    }
    private void backtrack(int[] nums,boolean[] used, LinkedList<Integer> track){
        if(track.size()==nums.length){
            ans.add(new LinkedList(track));
            return;
        }
        for(int i=0;i<nums.length;++i){
            if(used[i] || i>0 && nums[i-1]==nums[i] && !used[i-1]){
                //后半部分条件确保了相同的值在排列中保持与在nums中一样的顺序
                continue;
            }
            track.add(nums[i]);
            used[i] = true;
            backtrack(nums,used,track);
            used[i] = false;
            track.removeLast();
        }
    }
}
