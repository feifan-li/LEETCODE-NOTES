package DynamicProgramming.LC920NumberOfMusicPlaylists;

public class Solution920_bottom_up {
    public int numMusicPlaylists(int n, int goal, int k) {
        int MOD = 1_000_000_007;
        long[][] dp = new long[n+1][goal+1];
        //Base cases:
        //dp[0][i] = 0, no way to play >0 songs when 0 different songs are played
        //dp[i][0] = 0, no way to play 0 songs when >0 different songs are played
        dp[0][0] = 1L;//empty list
        for(int played=1;played<=n;++played){
            for(int len = 1;len<=goal;++len){
                //new song, chosen from unplayed songs
                dp[played][len] = (dp[played-1][len-1]*(n-played+1))%MOD;
                //old song cannot be chosen from first k different songs that have been played,
                //choose from last `played-k` played songs
                if(played>k) dp[played][len] = (dp[played][len]+(dp[played][len-1]*(played-k))%MOD)%MOD;
            }
        }
        return (int)dp[n][goal];
    }
}
