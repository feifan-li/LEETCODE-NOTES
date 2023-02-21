package DynamicProgramming.LC834SumOfDistancesInTree;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution834 {
    public static int[] ans;
    public static int[] dp;
    //G rooted at 0, tree T rooted at u,sum of distances between each node except u in T and u is dp[u]
    public static int[] size;
    public static ArrayList<ArrayList<Integer>> G;
    public static int[] sumOfDistancesInTree(int n, int[][] edges) {
        ans = new int[n];
        dp = new int[n];
        size = new int[n];
        Arrays.fill(size,1);
        //construct Graph:
        G = new ArrayList<>();
        for(int i=0;i<n;++i) G.add(new ArrayList<Integer>());
        for(int[] e:edges){
            G.get(e[0]).add(e[1]);
            G.get(e[1]).add(e[0]);
        }
        dfs(0,-1);
        //let every node be the root
        backtrack(0,-1);
        return dp;
    }
    private static void dfs(int u,int father){
        for(int v:G.get(u)){
            if(v==father) continue;
            dfs(v,u);
            dp[u] += dp[v]+size[v];
            size[u] += size[v];
        }
    }
    private static void backtrack(int u,int father){
        ans[u] = dp[u];
        for(int v:G.get(u)){
            if(v==father) continue;
            int dp_u = dp[u],dp_v = dp[v];
            int sz_u = size[u], sz_v = size[v];

            // let v be the root
            dp[u] -= dp[v]+size[v];
            size[u] -= size[v];
            dp[v] += dp[u] + size[u];
            size[v] += size[u];

            backtrack(v,u);
            //restore
            dp[u] = dp_u;
            dp[v] = dp_v;
            size[u] = sz_u;
            size[v] = sz_v;
        }
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sumOfDistancesInTree(6,new int[][]{{0,1},{0,2},{2,3},{2,4},{2,5}})));
//        System.out.println(Arrays.toString(sumOfDistancesInTree(1,new int[][]{})));
//        System.out.println(Arrays.toString(sumOfDistancesInTree(2,new int[][]{{1,0}})));
        System.out.println(Arrays.toString(ans));
        System.out.println(Arrays.toString(size));
    }
}
