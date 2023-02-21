package Tree.LC1443MinTimeToCollectAllApplesInATree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1443 {
    //starting at vertex 0 and coming back to this vertex.
    //dfs
    public static int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;++i){
            graph.add(new ArrayList<Integer>());
        }
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        visited[0] = true;
        int ans = dfs(graph,0,visited,hasApple);
        return ans == -1 ? 0:ans;
    }
    private static int dfs(List<List<Integer>> graph, int start,boolean[] visited,List<Boolean> hasApple){
        int sec = 0;
        List<Integer> neighbours = graph.get(start);
        for(int v:neighbours){
            if(!visited[v]){
                visited[v] = true;
                int has = dfs(graph,v,visited,hasApple);
                if(has!=-1){
                    sec = sec+has+2;
                }
            }
        }
        if(hasApple.get(start)) return sec;
        else return sec==0?-1:sec;
    }

    public static void main(String[] args) {
        System.out.println(minTime(7,new int[][]{{0,1},{0,2},{1,4},{1,5},{2,3},{2,6},}, Arrays.asList(false,false,true,false,true,true,false)));
        System.out.println(minTime(7,new int[][]{{0,1},{0,2},{1,4},{1,5},{2,3},{2,6},}, Arrays.asList(false,false,true,false,false,true,false)));
        System.out.println(minTime(7,new int[][]{{0,1},{0,2},{1,4},{1,5},{2,3},{2,6},}, Arrays.asList(false,false,false,false,false,false,false)));

    }
}
