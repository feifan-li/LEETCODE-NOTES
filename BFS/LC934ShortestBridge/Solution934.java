package BFS.LC934ShortestBridge;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution934 {
    public static int shortestBridge(int[][] grid) {
        int n = grid.length;
        int[][] island = new int[n][n];//0 unvisited or water,1:island 1,2:island 2
        int island1Size = markIsland(grid,island,1);
        int island2Size = markIsland(grid,island,2);
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                if(island[i][j]==(island1Size<island2Size?1:2)){
                    ans = Math.min(ans,bfs(island,i,j,(island1Size<island2Size?1:2),(island1Size<island2Size?2:1)));
                }
            }
        }
        return ans;
    }
    private static int markIsland(int[][] grid,int[][] island,int flag){
        int n = grid.length;
        int islandSize = 0;
        boolean islandMarked = false;
        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                if(grid[i][j]==1 && island[i][j]==0){
                    Queue<int[]> q = new LinkedList<>();
                    island[i][j] = flag;
                    q.offer(new int[]{i,j});
                    islandSize++;
                    while(!q.isEmpty()){
                        int size = q.size();
                        for(int cnt = 0;cnt<size;++cnt){
                            int[] u = q.poll();
                            if(u[0]-1>=0 && grid[u[0]-1][u[1]]==1 && island[u[0]-1][u[1]]==0){
                                island[u[0]-1][u[1]] = flag;
                                q.offer(new int[]{u[0]-1,u[1]});
                                islandSize++;
                            }
                            if(u[0]+1<n && grid[u[0]+1][u[1]]==1 && island[u[0]+1][u[1]]==0){
                                island[u[0]+1][u[1]] = flag;
                                q.offer(new int[]{u[0]+1,u[1]});
                                islandSize++;
                            }
                            if(u[1]-1>=0 && grid[u[0]][u[1]-1]==1 && island[u[0]][u[1]-1]==0){
                                island[u[0]][u[1]-1] = flag;
                                q.offer(new int[]{u[0],u[1]-1});
                                islandSize++;
                            }
                            if(u[1]+1<n && grid[u[0]][u[1]+1]==1 && island[u[0]][u[1]+1]==0){
                                island[u[0]][u[1]+1] = flag;
                                q.offer(new int[]{u[0],u[1]+1});
                                islandSize++;
                            }
                        }
                    }
                    islandMarked = true;
                    break;
                }
            }
            if(islandMarked)   break;
        }
        return islandSize;
    }
    private static int bfs(int[][] island,int i,int j,int sourceIsland,int targetIsland){
        int n = island.length;
        int steps = 0;
        boolean[][] visited = new boolean[n][n];
        visited[i][j] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i,j});
        while(!q.isEmpty()){
            int size = q.size();
            boolean newStep = false;
            boolean found = false;
            for(int cnt=0;cnt<size;++cnt){
                int[] u = q.poll();
                if(u[0]-1>=0 && !visited[u[0]-1][u[1]]){
                    visited[u[0]-1][u[1]] = true;
                    q.offer(new int[]{u[0]-1,u[1]});
                    newStep = true;
                    if(island[u[0]-1][u[1]]==targetIsland) found = true;
                }
                if(u[0]+1<n && !visited[u[0]+1][u[1]]){
                    visited[u[0]+1][u[1]] = true;
                    q.offer(new int[]{u[0]+1,u[1]});
                    newStep = true;
                    if(island[u[0]+1][u[1]]==targetIsland) found = true;
                }
                if(u[1]-1>=0 && !visited[u[0]][u[1]-1]){
                    visited[u[0]][u[1]-1] = true;
                    q.offer(new int[]{u[0],u[1]-1});
                    newStep = true;
                    if(island[u[0]][u[1]-1]==targetIsland) found = true;
                }
                if(u[1]+1<n && !visited[u[0]][u[1]+1]){
                    visited[u[0]][u[1]+1] = true;
                    q.offer(new int[]{u[0],u[1]+1});
                    newStep = true;
                    if(island[u[0]][u[1]+1]==targetIsland) found = true;
                }
            }
            if(newStep) steps++;
            if(found) return steps-1;
        }
        return steps-1;
    }
    public static void main(String[] args) {
        int[][] grid1 = new int[][]{{0,1},{1,0}};
        int[][] grid2 = new int[][]{{0,1,0},{0,0,0},{0,0,1}};
        int[][] grid3 = new int[][]{{1,1,1,1,1},{1,0,0,0,1},{1,0,1,0,1},{1,0,0,0,1},{1,1,1,1,1}};
        int[][] grid4 = new int[][]{{0,0,0,1,1},{0,0,0,1,1},{1,1,1,0,0},{1,1,1,0,0},{1,1,1,0,0}};
        shortestBridge(grid1);
    }
}
