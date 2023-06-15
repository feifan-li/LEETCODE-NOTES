package LC254FactorCombinations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution254 {
    public static List<List<Integer>> getFactors(int n) {
        return helper(n,2);
    }
    public static List<List<Integer>> helper(int n,int start){
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=start;i*i<=n;++i){
            if(n%i==0){
                ans.add(new ArrayList<Integer>(Arrays.asList(i,n/i)));
                List<List<Integer>> cur= helper(n/i,i);
                for(List<Integer> list:cur){
                    list.add(0,i);
                    ans.add(new ArrayList<Integer>(list));
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(getFactors(16));
    }
}
