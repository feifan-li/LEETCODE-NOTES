package Backtrack.LC1857LargestColorValueInADirectedGraph;

import java.util.ArrayList;

public class Solution1857 {
    public int ans = -1;
    public boolean[] visited;
    public boolean[] pathStack;
    public int[][] count;
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        count = new int[n][26];//以i起始的所有路径中，每种颜色在单一路径出现的最大次数
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;++i) graph.add(new ArrayList<Integer>());
        for(int[] e:edges) graph.get(e[0]).add(e[1]);
        visited = new boolean[n];
        pathStack = new boolean[n];
        for(int i=0;i<n;++i){
            ans = Math.max(ans,dfs(i,colors,graph));
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    private int dfs(int s,String colors,ArrayList<ArrayList<Integer>> graph){
        if(pathStack[s]) return Integer.MAX_VALUE;
        if(visited[s]) return count[s][colors.charAt(s)-'a'];
        visited[s] = true;
        pathStack[s] = true;
        int curColor = colors.charAt(s)-'a';
        if(graph.get(s)==null || graph.get(s).size()==0){
            count[s][curColor] += 1;
            pathStack[s] = false;
            return count[s][curColor];
        }
        for(int n:graph.get(s)){
            if(Integer.MAX_VALUE == dfs(n,colors,graph)) return Integer.MAX_VALUE;
            for(int i=0;i<26;++i) count[s][i] = Math.max(count[s][i],count[n][i]);
        }
        count[s][curColor] += 1;
        pathStack[s] = false;
        return count[s][curColor];
    }

}
