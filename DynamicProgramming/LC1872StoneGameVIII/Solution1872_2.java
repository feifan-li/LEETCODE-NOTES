package DynamicProgramming.LC1872StoneGameVIII;

public class Solution1872_2 {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        int[] sum = new int[n];
        sum[0] = stones[0];
        for(int i=1;i<n;++i)    sum[i] = stones[i]+sum[i-1];
        int dp = sum[n-1];
        for(int i=n-2;i>0;--i)  dp = Math.max(dp,sum[i]-dp);
        return dp;
    }
}
