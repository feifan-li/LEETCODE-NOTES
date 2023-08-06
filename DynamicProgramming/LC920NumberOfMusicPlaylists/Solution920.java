package DynamicProgramming.LC920NumberOfMusicPlaylists;

import java.util.Arrays;

public class Solution920 {
    public int MOD = 1_000_000_007;
    public long[][] dp;
    public int numMusicPlaylists(int n, int goal, int k) {
        dp = new long[n+1][goal+1];
        for(long[] row:dp)  Arrays.fill(row,-1);
        //Base cases:
        Arrays.fill(dp[0],0);//no way to play >0 songs but 0 different songs are played
        for(int i=0;i<=n;++i)   dp[i][0] = 0;//no way to play 0 songs but >0 different songs are played
        dp[0][0] = 1;//empty list
        return (int)helper(n,goal,n,k);
    }
    public long helper(int played, int goal, int n, int k) {
        if(dp[played][goal]!=-1)    return dp[played][goal];
        //new song, chosen from unplayed songs
        dp[played][goal] = (helper(played-1,goal-1,n,k)*(n-played+1))%MOD;
        //old song cannot be chosen from first k different songs that have been played,
        //choose from last `played-k` played songs
        if(played>k) dp[played][goal] = (dp[played][goal]+(helper(played,goal-1,n,k)*(played-k))%MOD)%MOD;
        return dp[played][goal];
    }
}
