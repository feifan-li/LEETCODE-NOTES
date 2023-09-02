package DynamicProgramming.LC2707ExtraCharsInAString;

import java.util.Arrays;
import java.util.HashSet;

public class Solution2707 {
    public HashSet<String> set = new HashSet<>();
    public int[][] memo;
    public int n;
    public int minExtraChar(String s, String[] dictionary) {
        for(String t:dictionary)    set.add(t);
        n = s.length();
        memo = new int[n][n];
        for(int i=0;i<n;++i)    Arrays.fill(memo[i],n*2);
        //base cases
        for(int i=0;i<n;++i){
            memo[i][i] = set.contains(s.substring(i,i+1))?0:1;
        }
        return dp(0,n-1,s);
    }
    public int dp(int l,int r,String s){
        // return extra chars in s.substring(l,r+1);
        if(memo[l][r]!=n*2){
            return memo[l][r];
        }
        if(set.contains(s.substring(l,r+1))){
            memo[l][r] = 0;
            return 0;
        }
        for(int i=l;i<r;++i){
            memo[l][r] = Math.min(memo[l][r],dp(l,i,s)+dp(i+1,r,s));
        }
        return memo[l][r];
    }
}
