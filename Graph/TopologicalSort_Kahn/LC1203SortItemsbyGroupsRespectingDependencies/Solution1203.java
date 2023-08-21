package Graph.TopologicalSort_Kahn.LC1203SortItemsbyGroupsRespectingDependencies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution1203 {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        // 使不属于任何小组的元素自成一组
        for(int i=0;i<n;++i){
            if(group[i]==-1){
                group[i] = m;
                m++;
            }
        }
        // Build Graphs, indegree[]
        HashMap<Integer, ArrayList<Integer>> itemGraph = new HashMap<>();
        for(int i=0;i<n;++i)    itemGraph.put(i,new ArrayList<>());
        int[] itemIndegree = new int[n];
        HashMap<Integer, ArrayList<Integer>> groupGraph = new HashMap<>();
        for(int i=0;i<m;++i)    groupGraph.put(i,new ArrayList<>());
        int[] groupIndegree = new int[m];
        for(int i=0;i<n;++i){
            for(int prev:beforeItems.get(i)){
                itemGraph.get(prev).add(i);
                itemIndegree[i]++;
                if(group[i]!=group[prev]){
                    groupGraph.get(group[prev]).add(group[i]);
                    groupIndegree[group[i]]++;
                }
            }
        }
        // Topological sort on two Graphs
        List<Integer> groupOrder = topologicalSort(groupGraph,groupIndegree);
        List<Integer> itemOrder = topologicalSort(itemGraph,itemIndegree);
        // Merge two topological sorted lists
        if(groupOrder==null || itemOrder==null) return new int[0];
        HashMap<Integer, ArrayList<Integer>> groupToSortedItems = new HashMap<>();
        for(int item:itemOrder){
            groupToSortedItems.computeIfAbsent(group[item],k->new ArrayList<>());
            groupToSortedItems.get(group[item]).add(item);
        }
        int[] ans = new int[n];
        int ansIndex = 0;
        for(int groupId:groupOrder){
            // 注意不是所有group都有items
            for(int item:groupToSortedItems.getOrDefault(groupId,new ArrayList<>())) ans[ansIndex++] = item;
        }
        return ans;
    }
    public List<Integer> topologicalSort(HashMap<Integer, ArrayList<Integer>> g, int[] indegree){
        List<Integer> ans = new ArrayList<>();
        int[] stack = new int[indegree.length];
        int top = -1;
        for(int i=0;i<indegree.length;++i){
            if(indegree[i]==0)  stack[++top] = i;
        }
        while(top>=0){
            int u = stack[top--];
            ans.add(u);
            for(int v:g.get(u)){
                indegree[v]--;
                if(indegree[v]==0)  stack[++top] = v;
            }
        }
        return ans.size()==indegree.length?ans:null;
    }
}
