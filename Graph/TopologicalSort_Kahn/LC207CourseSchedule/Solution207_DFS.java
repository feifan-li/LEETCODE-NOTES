package Graph.TopologicalSort_Kahn.LC207CourseSchedule;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution207_DFS {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();//directed
        for(int i=0;i<numCourses;++i)   graph.add(new ArrayList<Integer>());
        for(int[] e:prerequisites){
            if(e[0]==e[1])  return false;
            graph.get(e[0]).add(e[1]);
        }
        int[] visited = new int[numCourses];//-1:unvisited, 0:no circle, 1: circle
        Arrays.fill(visited,-1);
        for(int i=0;i<numCourses;++i){
            if(visited[i]==-1){
                boolean[] path = new boolean[numCourses];
                if(dfs(graph,visited,path,i)==true) return false;//found circle
            }
        }
        return true;
    }
    public boolean dfs(ArrayList<ArrayList<Integer>> graph, int[] visited, boolean[] path, int s){
        if(visited[s]==0)   return false;
        else if(visited[s]==1)  return true;
        path[s] = true;
        for(int u:graph.get(s)){
            if(!path[u]){
                if(dfs(graph,visited,path,u)){
                    path[s] = false;
                    visited[s] = 1;
                    return true;
                }
            }else{
                path[s] = false;
                visited[s] = 1;
                return true;
            }
        }
        path[s] = false;
        visited[s] = 0;
        return false;
    }
}
