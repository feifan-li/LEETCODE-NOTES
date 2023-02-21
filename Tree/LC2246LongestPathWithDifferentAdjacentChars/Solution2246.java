package Tree.LC2246LongestPathWithDifferentAdjacentChars;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution2246 {
    public static int ans = 1;
    public static int longestPath(int[] parent, String s) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<parent.length;++i){
            graph.add(new ArrayList<>());
        }
        for(int i=1;i<parent.length;++i){
            graph.get(i).add(parent[i]);
            graph.get(parent[i]).add(i);
        }
        boolean[] visited = new boolean[parent.length];
        visited[0] = true;
        dfs(graph,s,visited,0);
        return ans;
    }
    private static int dfs(List<List<Integer>> graph,String s,boolean[] visited,int root){
        List<Integer> children = graph.get(root);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b)->b-a);
        for(int v:children){
            if(!visited[v]){
                visited[v] = true;
                int childLength = dfs(graph,s,visited,v);
                if(s.charAt(root)==s.charAt(v)) childLength = 0;
                maxHeap.offer(childLength);
            }
        }
        int max_1 = 0,max_2 = 0;
        if(!maxHeap.isEmpty()){
            max_1 = maxHeap.poll();
        }
        if(!maxHeap.isEmpty()){
            max_2 = maxHeap.poll();
        }
        ans = Math.max(ans,max_1+max_2+1);
        return max_1+1;
    }

    public static void main(String[] args) {
//        System.out.println(longestPath(new int[]{-1,0,0,1,1,2},"abacbe"));
//        System.out.println(longestPath(new int[]{-1,0,0,0},"aabc"));
    }
}
