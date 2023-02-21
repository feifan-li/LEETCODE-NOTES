package LC491NonDecreasingSubsequences;

import java.util.LinkedList;
import java.util.List;

public class Solution491 {
    static List<Integer> list = new LinkedList<>();
    static List<List<Integer>> ans = new LinkedList<>();
    public static List<List<Integer>> findSubsequences(int[] nums) {
        backtrack(nums,-9999,0);
        return ans;
    }
    private static void backtrack(int[] nums,int lastVal,int curIdx){
        if(curIdx == nums.length){
            if(list.size()>=2) ans.add(new LinkedList<>(list));
            return;
        }
        //now consider the option list of nums[cur]
        //option1: choose nums[cur] -> prerequisite: non-descreasing
        if(nums[curIdx]>=lastVal){
            list.add(nums[curIdx]);
            backtrack(nums,nums[curIdx],curIdx+1);
            list.remove(list.size()-1);
        }
        //option2: skip nums[cur]
        if(nums[curIdx]!=lastVal){// avoid duplicates:
                                  // when nums[curIdx] = lastVal, nums[curIdx] has been chosen together with lastVal.
                                  // we know that there has already been a case when lastVal was skipped and nums[curIdx] was chosen
                                  // if lastVal was chosen but nums[curIdx] is skipped now, there will be duplicates!
            backtrack(nums,lastVal,curIdx+1);
        }
    }

    public static void main(String[] args) {
        System.out.println(findSubsequences(new int[]{4,6,7,7}));
    }
}
