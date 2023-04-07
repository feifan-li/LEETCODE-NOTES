package BFS.LC1020NumberOfEnclaves;

import java.util.LinkedList;
import java.util.Queue;

public class Solution1020 {
    public static boolean[][] visited;
    public static int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        if(m==1 || n==1) return 0;
        visited = new boolean[m][n];
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                if(grid[i][j]==1 && !visited[i][j]){
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i,j});
                    visited[i][j] = true;
                    ans += bfs(grid,q);
                }
            }
        }
        return ans;
    }
    public static int bfs(int[][] grid,Queue<int[]> q){
        boolean isEnclave = true;
        int lands = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int cnt = 0;cnt<size;cnt++){
                int[] s = q.poll();
                int i = s[0],j = s[1];
                /**UP**/
                if(i-1>=0 && grid[i-1][j]==1 && !visited[i-1][j]){
                    q.offer(new int[]{i-1,j});
                    visited[i-1][j] = true;
                    lands++;
                }else if(i-1<0) isEnclave = false;
                /**LEFT**/
                if(j-1>=0 && grid[i][j-1]==1 && !visited[i][j-1]){
                    q.offer(new int[]{i,j-1});
                    visited[i][j-1] = true;
                    lands++;
                }else if(j-1<0) isEnclave = false;
                /**RIGHT**/
                if(j+1<grid[0].length && grid[i][j+1]==1 && !visited[i][j+1]){
                    q.offer(new int[]{i,j+1});
                    visited[i][j+1] = true;
                    lands++;
                }else if(j+1>=grid[0].length) isEnclave = false;
                /**DOWN**/
                if(i+1<grid.length && grid[i+1][j]==1 && !visited[i+1][j]){
                    q.offer(new int[]{i+1,j});
                    visited[i+1][j] = true;
                    lands++;
                }else if(i+1>=grid.length) isEnclave = false;
            }
        }
        return isEnclave?lands:0;
    }

    public static void main(String[] args) {
        System.out.println(numEnclaves(new int[][]{{0, 0, 0, 0}, {1, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}}));
        System.out.println(numEnclaves(new int[][]{{0, 1, 1, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}}));
    }
}
