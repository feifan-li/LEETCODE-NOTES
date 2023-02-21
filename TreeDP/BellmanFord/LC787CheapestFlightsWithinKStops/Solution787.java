package TreeDP.BellmanFord.LC787CheapestFlightsWithinKStops;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution787{
    //Bellman-Ford Algorithm
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for(int i=0;i<n;++i) graph.add(new ArrayList<int[]>());
        for(int[] e:flights){
            int v = e[0], w = e[1], cost = e[2];
            graph.get(v).add(new int[]{w,cost});
        }
        int[][] dp = new int[k+2][n];
        //dp(i,v) denotes the min cost of a v-dst path using at most i edges
        //dp(i,v) = min(dp(i-1,v),min(dp(i-1,w)+cost(v,w))), w are v's neighbours
        //base case:dp(0,dst)=0, dp(0,v) = +inf;
        Arrays.fill(dp[0],0x3f3f3f3f);
        dp[0][dst]=0;
        for(int i=1;i<=k+1;++i){
            for(int v=0;v<n;++v){
                int tmp = Integer.MAX_VALUE;
                for(int[] e:graph.get(v)){
                    tmp = Math.min(tmp,dp[i-1][e[0]]+e[1]);
                }
                dp[i][v] = Math.min(dp[i-1][v],tmp);
            }
        }
        return dp[k+1][src]>=0x3f3f3f3f? -1:dp[k+1][src];
    }
}
