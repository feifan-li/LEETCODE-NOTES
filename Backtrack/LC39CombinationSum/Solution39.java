package Backtrack.LC39CombinationSum;

import java.util.ArrayList;
import java.util.List;
//Given an array of distinct integers candidates and a target integer target,
//return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
//
//The same number may be chosen from candidates an unlimited number of times.
public class Solution39 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res,new ArrayList<Integer>(),0,candidates,target);
        return res;
    }
    private static void helper(List<List<Integer>> res,List<Integer> list,int start,int[] candidates,int target){
        if(target<0) return;
        if(target==0){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=start;i<candidates.length;++i){
            list.add(candidates[i]);
            helper(res,list,i,candidates,target-candidates[i]);
            //backtrack:
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2,3,5},8));
        System.out.println(combinationSum(new int[]{2,3,6,7},7));
    }
}
