package Backtrack.LC216CombinationSumIII;

import java.util.ArrayList;
import java.util.List;

public class Solution216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans,new ArrayList<Integer>(),0,k,n);
        return ans;
    }
    public void backtrack(List<List<Integer>> ans,ArrayList<Integer> list,int sum,int k,int n){
        if(list.size()==k && sum==n){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(list.size()==k)  return;
        for(int i=list.size()==0?1:list.get(list.size()-1)+1;i<=9;++i){
            list.add(i);
            backtrack(ans,list,sum+i,k,n);
            list.remove(list.size()-1);
        }
    }
}
