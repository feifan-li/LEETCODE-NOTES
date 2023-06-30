package BFS.LC1970LastDayWhereYouCanStillCross;

import java.util.LinkedList;
import java.util.Queue;

public class Solution1970 {
    public int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int latestDayToCross(int row, int col, int[][] cells) {
        int left = 0, right = row*col-1-row;//0-based index in cells
        while(left<=right){
            int mid = left + (right-left)/2;
            if(possible(row,col,cells,mid)) left = mid+1;
            else    right = mid-1;
        }
        return right+1;
    }
    public boolean possible(int row,int col,int[][] cells,int mid){
        int[][] grid = new int[row][col];//initially, all land
        for(int i=0;i<=mid;++i){
            int[] water = cells[i];
            grid[water[0]-1][water[1]-1] = 1;
        }
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[row][col];
        for(int j=0;j<col;++j){
            if(grid[0][j]==0){
                q.offer(new int[]{0,j});
                visited[0][j] = true;
            }
        }
        while(!q.isEmpty()){
            int[] u = q.poll();
            if(u[0]==row-1) return true;
            for(int[] dir:dirs){
                if(u[0]+dir[0]>=0 && u[0]+dir[0]<row && u[1]+dir[1]>=0 && u[1]+dir[1]<col
                        && grid[u[0]+dir[0]][u[1]+dir[1]]==0 && !visited[u[0]+dir[0]][u[1]+dir[1]]){
                    q.offer(new int[]{u[0]+dir[0],u[1]+dir[1]});
                    visited[u[0]+dir[0]][u[1]+dir[1]] = true;
                }
            }
        }
        return false;
    }
}
