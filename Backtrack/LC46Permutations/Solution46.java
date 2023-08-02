package Backtrack.LC46Permutations;

import java.util.LinkedList;
import java.util.List;

public class Solution46 {
    List<List<Integer>> ans = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums,new boolean[nums.length],new LinkedList<>());
        return ans;
    }
    private void backtrack(int[] nums,boolean[] used, LinkedList<Integer> track){
        if(track.size() == nums.length){
            ans.add(new LinkedList(track));
            return;
        }
        for(int i=0;i<nums.length;++i){
            if(used[i]) continue;
            track.add(nums[i]);
            used[i] = true;
            backtrack(nums,used,track);
            used[i] = false;
            track.removeLast();
        }
    }
}
