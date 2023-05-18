package Greedy.LC1557MinNumberOfVerticesToReachAllNodes;

import java.util.ArrayList;
import java.util.List;

public class Solution1557 {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] incoming  = new boolean[n];
        for(List<Integer> e:edges){incoming[e.get(1)] = true; }
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;++i)    if(!incoming[i]) ans.add(i);
        return ans;
    }
}
