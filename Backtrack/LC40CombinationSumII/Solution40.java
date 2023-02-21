package Backtrack.LC40CombinationSumII;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
//Given a collection of candidate numbers (candidates) and a target number (target),
// find all unique combinations in candidates where the candidate numbers sum to target.
//
//Each number in candidates may only be used once in the combination.
//
//Note: The solution set must not contain duplicate combinations.
public class Solution40 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new LinkedList<>();
        helper(res,new LinkedList<>(),0,candidates,target);
        return res;
    }
    private static void helper(List<List<Integer>> res, LinkedList<Integer> list,int start,int[] cd,int t){
        if(t<0) return;
        if(t==0){
            res.add(new LinkedList<>(list));
            return;
        }
        for(int i=start;i<cd.length;++i){
            if(i>start && cd[i]==cd[i-1]) continue;
            list.add(cd[i]);
            helper(res,list,i+1,cd,t-cd[i]);
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{10,1,2,7,6,1,5},8));
        System.out.println(combinationSum2(new int[]{2,5,2,1,2},5));

    }
}
