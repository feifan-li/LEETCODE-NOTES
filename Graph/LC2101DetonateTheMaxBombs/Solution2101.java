package Graph.LC2101DetonateTheMaxBombs;

import java.util.ArrayList;

public class Solution2101 {
    public static int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;++i){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<n-1;++i){
            for(int j=i+1;j<n;++j){
                if(canDetonate(bombs[i],bombs[j]))  graph.get(i).add(j);
                if(canDetonate(bombs[j],bombs[i]))  graph.get(j).add(i);
            }
        }
        int ans = 0;
        for(int i=0;i<n;++i){
            boolean[] visited = new boolean[n];
            int cnt = dfs(graph,visited,i);
            if(cnt==n)  return n;
            ans = Math.max(ans,cnt);
        }
        return ans;
    }
    public static int dfs(ArrayList<ArrayList<Integer>> graph,boolean[] visited,int s){
        visited[s] = true;
        int cnt = 1;
        for(int u:graph.get(s)){
            if(!visited[u]){
                cnt += dfs(graph,visited,u);
            }
        }
        return cnt;
    }
    public static boolean canDetonate(int[] a,int[] b){
        long dx = a[0] - b[0];
        long dy = a[1] - b[1];
        long r = a[2];
        return dx*dx+dy*dy <= r*r;
    }

    public static void main(String[] args) {
        int[][] bombs = new int[][]{{54, 95, 4}, {99, 46, 3}, {29, 21, 3}, {96, 72, 8}, {49, 43, 3}, {11, 20, 3}, {2, 57, 1}, {69, 51, 7},
                                    {97, 1, 10}, {85, 45, 2}, {38, 47, 1}, {83, 75, 3}, {65, 59, 3}, {33, 4, 1}, {32, 10, 2}, {20, 97, 8}, {35, 37, 3}};
        System.out.println(maximumDetonation(bombs));
    }
}
