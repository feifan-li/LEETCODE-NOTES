package Graph.TopologicalSort_Kahn.LC207CourseSchedule;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution207_TopologicalSort {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] in = new int[numCourses];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();//directed
        for(int i=0;i<numCourses;++i)   graph.add(new ArrayList<Integer>());
        for(int[] e:prerequisites){
            if(e[0]==e[1])  return false;
            graph.get(e[1]).add(e[0]);
            in[e[0]] ++;
        }
        Queue<Integer> queue = new LinkedList<>();
        int visited = 0;
        for(int i=0;i<numCourses;++i){
            if(in[i] == 0){
                queue.offer(i);
                visited++;
            }
        }
        while(!queue.isEmpty()){
            int u = queue.poll();
            for(int v:graph.get(u)){
                in[v] --;
                if(in[v]==0){
                    queue.offer(v);
                    visited++;
                }
            }
        }
        return visited == numCourses;
    }
}
