package BFS.LC1091ShortestPathInBinaryMatrix;

import java.util.LinkedList;
import java.util.Queue;

public class Solution1091 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1)  return -1;
        if(n==1)    return 1;
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{-1,-1},{-1,1},{1,-1},{1,1}};
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        int steps = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int cnt = 0;cnt<size;++cnt){
                int[] u = q.poll();
                for(int[] dir:dirs){
                    if(u[0]+dir[0]>=0 && u[0]+dir[0]<n && u[1]+dir[1]>=0 && u[1]+dir[1]<n &&
                            grid[u[0]+dir[0]][u[1]+dir[1]]==0 && !visited[u[0]+dir[0]][u[1]+dir[1]]){
                        if(u[0]+dir[0] == n-1 && u[1]+dir[1] == n-1)    return steps+1;
                        visited[u[0]+dir[0]][u[1]+dir[1]] = true;
                        q.offer(new int[]{u[0]+dir[0],u[1]+dir[1]});
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
