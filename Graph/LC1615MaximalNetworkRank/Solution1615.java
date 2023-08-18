package Graph.LC1615MaximalNetworkRank;

import java.util.HashMap;
import java.util.HashSet;

public class Solution1615 {
    public int maximalNetworkRank(int n, int[][] roads) {
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        for(int i=0;i<n;++i)    graph.put(i,new HashSet<>());
        for(int[] road:roads){
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }
        int max = 0;
        for(int i=0;i<n;++i){
            for(int j=i+1;j<n;++j){
                max = Math.max(max,graph.get(i).size()+graph.get(j).size()-(graph.get(i).contains(j)?1:0));
            }
        }
        return max;
    }
}
