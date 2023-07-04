package Graph.TopologicalSort_Kahn.LC310MinimumHeightTrees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Solution310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        //find the central node(s)
        ArrayDeque<Integer> ans = new ArrayDeque<>();
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        int[] degree = new int[n];
        for(int i=0;i<n;++i)    g.add(new ArrayList<Integer>());
        for(int[] e:edges){
            g.get(e[0]).add(e[1]);
            g.get(e[1]).add(e[0]);
            degree[e[0]]++;
            degree[e[1]]++;
        }
        for(int i=0;i<n;++i){
            if(degree[i]==1 || degree[i]==0)  ans.offer(i);
        }
        while(n>2){
            int sz = ans.size();
            n -= sz;
            for(int cnt = 0;cnt < sz;++cnt){
                int u = ans.poll();
                for(int v:g.get(u)){
                    if(--degree[v]==1) ans.add(v);
                }
            }
        }
        return new ArrayList<Integer>(ans);
    }
}
