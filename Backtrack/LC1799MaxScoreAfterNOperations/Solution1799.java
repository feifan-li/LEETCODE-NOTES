package Backtrack.LC1799MaxScoreAfterNOperations;

import java.util.Arrays;

public class Solution1799 {
    public int maxScore(int[] nums) {
        int[] memo = new int[1<<nums.length];
        Arrays.fill(memo,-1);
        return backtrack(nums,0,0,memo);
    }
    private int backtrack(int[] nums,int mask,int pairs,int[] memo){
        if(pairs*2 == nums.length)  return 0;
        if(memo[mask] != -1)    return memo[mask];
        int maxScore = 0;
        for(int i=0;i<nums.length;++i){
            for(int j = i+1;j<nums.length;++j){
                if(((mask>>i)&1)==1 || ((mask>>j)&1)==1)    continue;
                int newMask = mask | (1<<i) | (1<<j);
                int curScore = (pairs+1)*gcd(nums[i],nums[j]);
                int remainingScore = backtrack(nums,newMask,pairs+1,memo);
                maxScore = Math.max(maxScore,curScore + remainingScore);
            }
        }
        memo[mask] = maxScore;
        return maxScore;
    }
    private int gcd(int x,int y){return y==0?x:gcd(y,x%y);}
}
