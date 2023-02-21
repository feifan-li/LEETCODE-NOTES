package BFS.LC1162AsFarFromLandAsPossible;

import java.util.LinkedList;
import java.util.Queue;

public class Solution1162 {
    public static Queue<int[]> q = new LinkedList<>();
    public static boolean[][] visited = new boolean[100][100];
    public static int find;
    public static int maxDistance(int[][] grid) {
        int n = grid.length;
        int waters = 0;
        find = 0;
        //add all lands to queue, check the number of waters
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 0) waters++;
                else{
                    q.offer(new int[]{i,j});
                    visited[i][j] = true;
                    System.out.println("Added: "+"["+i+","+j+"]");
                }
            }
        }
        System.out.println("Waters number: "+waters);
        if(waters==0 || waters==n*n) return -1;
        int distance = 0;
        while(!q.isEmpty() && find<waters){
            int size = q.size();
            for(int i=1;i<=size&&find<waters;++i){
                int[] item = q.poll();
                int row = item[0];
                int col = item[1];
                System.out.println("Polled: "+"["+row+","+col+"]");
                //only up down left right:
                add(row+1,col,grid);
                add(row-1,col,grid);
                add(row,col-1,grid);
                add(row,col+1,grid);
            }
            distance++;
        }

        return find==0 ? -1:distance;
    }
    public static void add(int row,int col,int[][] grid){
        int n = grid.length;
        if(row>=0 && row<n && col>=0 && col<n && !visited[row][col] && grid[row][col]==0){
            find++;
            q.offer(new int[]{row,col});
            visited[row][col] = true;
            System.out.println("Added: "+"["+row+","+col+"]");
        }
    }
    public static void main(String[] args) {
        int[][] grid1 = new int[][]{new int[]{1,0,1},new int[]{0,0,0},new int[]{1,0,1}};
        int[][] grid2 = new int[][]{new int[]{1,0,0}, new int[]{0,0,0},new int[]{0,0,0}};
        System.out.println("Max dist: "+maxDistance(grid1));
//        System.out.println("Max dist: "+maxDistance(grid2));

    }
}
