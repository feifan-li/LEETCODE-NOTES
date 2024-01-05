package LC2610ConvertAnArrayIntoA2dArrayWithConditions;

import java.util.ArrayList;
import java.util.List;

public class Solution2610 {
    public List<List<Integer>> findMatrix(int[] nums) {
        //num of rows = max repetitions in nums
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int n = nums.length;
        int[] cnt = new int[n+1];
        for(int num:nums){
            cnt[num]++;
        }
        while(n>0){
            List<Integer> row = new ArrayList<Integer>();
            for(int i=1;i<cnt.length;++i){
                if(cnt[i]>0){
                    row.add(i);
                    cnt[i]--;
                    n--;
                }
            }
            ans.add(row);
        }
        return ans;
    }
}
