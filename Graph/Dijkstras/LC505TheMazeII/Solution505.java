package Graph.Dijkstras.LC505TheMazeII;

import java.util.Arrays;

public class Solution505 {
    public int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int shortestDistance(int[][] maze, int[] s, int[] dst) {
        int m = maze.length, n = maze[0].length;
        int[][] dist = new int[m][n];
        for(int[] distRow:dist) Arrays.fill(distRow,999999);
        dist[s[0]][s[1]] = 0;//exclude the start position
        dfs(maze,dist,s,dst,m,n);
        return dist[dst[0]][dst[1]]==999999?-1:dist[dst[0]][dst[1]];
    }
    public void dfs(int[][] maze,int[][] dist,int[] s,int[] dst,int m,int n){
        for(int[] dir:dirs){
            int row = s[0]+dir[0], col = s[1]+dir[1], cnt = 0;
            while(row>=0 && col>=0 && row<m && col<n && maze[row][col]==0){
                row += dir[0];
                col += dir[1];
                cnt++;
            }
            if(dist[s[0]][s[1]]+cnt<dist[row-dir[0]][col-dir[1]]){
                dist[row-dir[0]][col-dir[1]] = dist[s[0]][s[1]]+cnt;
                dfs(maze,dist,new int[]{row-dir[0],col-dir[1]},dst,m,n);
            }
        }
    }
}
