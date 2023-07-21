package Backtrack.LC78Subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution78 {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums,0,new ArrayList<Integer>());
        return res;
    }
    public void backtrack(int[] nums,int start, ArrayList<Integer> track){
        res.add(new ArrayList(track));
        for(int i=start;i<nums.length;++i){
            track.add(nums[i]);
            backtrack(nums,i+1,track);
            track.remove(track.size()-1);
        }
    }
}
