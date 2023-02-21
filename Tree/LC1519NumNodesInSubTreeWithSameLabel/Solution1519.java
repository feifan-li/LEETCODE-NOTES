package Tree.LC1519NumNodesInSubTreeWithSameLabel;

import java.util.*;

public class Solution1519 {
    //any node is part of its sub-tree
    public static int[] countSubTrees(int n, int[][] edges, String labels) {
        int[] ans = new int[n];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;++i){
            graph.add(new ArrayList<Integer>());
            ans[i]=1;
        }
        for(int[] e:edges){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        boolean[] visited = new boolean[n];
        visited[0]=true;
        HashSet<Character> labelSet = new HashSet<>();
        for(int i=0;i<labels.length();++i){
            labelSet.add(Character.valueOf(labels.charAt(i)));
        }
        dfs(graph,visited,labels,labelSet,ans,0);
        return ans;
    }
    private static HashMap<Character,Integer> dfs(List<List<Integer>> graph, boolean[] visited, String labels, HashSet<Character> labelSet, int[] ans, int root){
        List<Integer> neighbours = graph.get(root);
        HashMap<Character,Integer> mapRoot = new HashMap<>();
        mapRoot.put(Character.valueOf(labels.charAt(root)),1);
        for(int v:neighbours){
            if(!visited[v]){
                visited[v] = true;
                HashMap<Character,Integer> mapV = dfs(graph,visited,labels,labelSet,ans,v);
                for(Map.Entry<Character,Integer> entry: mapV.entrySet()){
                    Character c = entry.getKey();
                    Integer val = entry.getValue();
                    mapRoot.put(c,mapRoot.getOrDefault(c,0)+val);
                }
            }
        }
        ans[root]=mapRoot.get(labels.charAt(root));
        return mapRoot;
    }

    public static void main(String[] args) {

    }
}
