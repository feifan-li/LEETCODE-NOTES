package Graph.TopologicalSort_Kahn.LC210CourseScheduleII;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];
        int ansTail = -1;
        int[] in = new int[numCourses];
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        for(int i=0;i<numCourses;++i)   g.add(new ArrayList<>());
        for(int[] e:prerequisites){
            g.get(e[1]).add(e[0]);
            in[e[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        int visited = 0;
        for(int i=0;i<numCourses;++i){
            if(in[i]==0){
                q.offer(i);
                visited++;
            }
        }
        while(!q.isEmpty()){
            int u = q.poll();
            ans[++ansTail] = u;
            for(int v:g.get(u)){
                in[v]--;
                if(in[v]==0){
                    q.offer(v);
                    visited++;
                }
            }
        }
        if(visited<numCourses){
            return new int[]{};
        }else{
            assert ansTail == numCourses-1;
            return ans;
        }
    }
}
