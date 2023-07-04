package BFS.LC317ShortestDistanceFromAllBuildings;

import java.util.LinkedList;
import java.util.Queue;

public class Solution317 {
    public int min = Integer.MAX_VALUE;
    public int houses = 0;
    public int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int shortestDistance(int[][] grid) {
        for(int i=0;i<grid.length;++i){
            for(int j=0;j<grid[0].length;++j){
                if(grid[i][j]==1)   houses++;
            }
        }
        for(int i=0;i<grid.length;++i){
            for(int j=0;j<grid[0].length;++j){
                if(grid[i][j]==0)   min = Math.min(min,bfs(grid,i,j));
            }
        }
        return (min==Integer.MAX_VALUE || min==0)?-1:min;
    }
    public int bfs(int[][] grid,int i,int j){
        int sum = 0, houseReached = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        visited[i][j] = true;
        q.offer(new int[]{i,j,0});
        while(!q.isEmpty()){
            int[] u = q.poll();
            for(int[] dir:dirs){
                int row = u[0]+dir[0], col = u[1]+dir[1];
                if(row>=0 && col>=0 && row<m && col<n && !visited[row][col] && grid[row][col]!=2){
                    visited[row][col] = true;
                    if(grid[row][col]==1){
                        sum += (u[2]+1);
                        if(++houseReached==houses)  return sum;
                    }else{
                        q.offer(new int[]{row,col,u[2]+1});
                    }
                }
            }
        }
        return houseReached==houses?sum:Integer.MAX_VALUE;
    }
}
