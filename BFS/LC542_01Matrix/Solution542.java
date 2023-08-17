package BFS.LC542_01Matrix;

import java.util.LinkedList;
import java.util.Queue;

public class Solution542 {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        int[][] ans = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                if(mat[i][j]==0){
                    visited[i][j] = true;
                    q.offer(new int[]{i,j,0});
                }
            }
        }
        while(!q.isEmpty()){
            int[] u = q.poll();
            for(int[] dir:dirs){
                if(u[0]+dir[0]>=0 && u[0]+dir[0]<m && u[1]+dir[1]>=0 && u[1]+dir[1]<n
                        && !visited[u[0]+dir[0]][u[1]+dir[1]] && mat[u[0]+dir[0]][u[1]+dir[1]]==1){
                    ans[u[0]+dir[0]][u[1]+dir[1]] = u[2]+1;
                    visited[u[0]+dir[0]][u[1]+dir[1]] = true;
                    q.offer(new int[]{u[0]+dir[0],u[1]+dir[1],u[2]+1});
                }
            }
        }

        return ans;
    }
}
