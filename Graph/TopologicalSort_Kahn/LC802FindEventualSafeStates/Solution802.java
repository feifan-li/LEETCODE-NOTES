package Graph.TopologicalSort_Kahn.LC802FindEventualSafeStates;

import java.util.*;

public class Solution802 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] outdegree = new int[n];
        ArrayList<ArrayList<Integer>> parents = new ArrayList<>();
        for(int i=0;i<n;++i)    parents.add(new ArrayList<Integer>());
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;++i){
            outdegree[i] = graph[i].length;
            if(outdegree[i]==0) q.offer(i);
            for(int u:graph[i]) parents.get(u).add(i);
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int u = q.poll();
            ans.add(u);
            for(int parent:parents.get(u)){
                if((--outdegree[parent])==0)    q.offer(parent);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
