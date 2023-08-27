package DynamicProgramming.LC403FrogJump;

import java.util.HashMap;

public class Solution403 {
    public HashMap<Integer,Integer> map = new HashMap<>();
    public boolean[][] dp;
    public boolean canCross(int[] stones) {
        if(stones[1]!=1)    return false;
        if(stones.length<=2)    return true;
        for(int i=0;i<stones.length;++i)    map.put(stones[i],i);
        dp = new boolean[stones.length][2002];
        solve(stones,1,1);
        for(int k=0;k<dp[stones.length-1].length;++k){
            if(dp[stones.length-1][k])  return true;
        }
        return false;
    }
    public void solve(int[] stones,int i, int k){
        if(i==-1)   return;
        if(dp[i][k]==true)   return;
        dp[i][k] = true;
        if(k>1) solve(stones,map.getOrDefault(stones[i]+k-1,-1),k-1);
        if(k>0) solve(stones,map.getOrDefault(stones[i]+k,-1),k);
        solve(stones,map.getOrDefault(stones[i]+k+1,-1),k+1);
    }
}
