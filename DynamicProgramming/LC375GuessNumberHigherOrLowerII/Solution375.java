package DynamicProgramming.LC375GuessNumberHigherOrLowerII;

import java.util.Arrays;

public class Solution375 {
    public int[][] memo;
    public int getMoneyAmount(int n) {
        memo = new int[n+1][n+1];
        for(int left=1;left<=n;++left){
            Arrays.fill(memo[left],-1);
            for(int right=1;right<=left;++right) memo[left][right] = 0;
            if(left+1<=n)   memo[left][left+1] = left;
        }
        return guess(1,n);
    }
    public int guess(int left,int right){
        if(left>=right) return 0;
        if(memo[left][right]!=-1)   return memo[left][right];
        int min = Integer.MAX_VALUE;
        for(int i=left;i<=right;++i){
            min = Math.min(min,i+Math.max(guess(left,i-1),guess(i+1,right)));
        }
        memo[left][right] = min;
        return min;
    }
}
