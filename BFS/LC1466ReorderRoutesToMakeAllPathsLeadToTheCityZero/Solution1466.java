package BFS.LC1466ReorderRoutesToMakeAllPathsLeadToTheCityZero;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution1466 {
    public int minReorder(int n, int[][] connections) {
        //represent graph using an ajacent matrix
        int ans = 0;
        ArrayList<ArrayList<int[]>> g = new ArrayList<>();
        for(int i=0;i<n;++i){
            g.add(new ArrayList<>());
        }
        for(int[] e:connections){
            g.get(e[0]).add(new int[]{e[1],0});//e[0]->e[1] not reversed
            g.get(e[1]).add(new int[]{e[0],1});//e[1]->e[0] reversed
        }
        //BFS from node 0
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        boolean[] visited = new boolean[n];
        visited[0] = true;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=1;i<=size;++i){
                int node = q.poll();
                for(int[] u:g.get(node)){
                    if(!visited[u[0]]){
                        q.offer(u[0]);
                        visited[u[0]] = true;
                        ans += u[1]==1?0:1;
                    }
                }
            }
        }
        return ans;
    }
}
