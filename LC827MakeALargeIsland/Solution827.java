package LC827MakeALargeIsland;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Solution827 {
    public static int[] parent;
    public static int[] size;
    public static int largestIsland(int[][] grid) {
        //BFS + UnionFind
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        parent = new int[m*n];
        size = new int[m*n];
        for(int i=0;i<m*n;++i){
            parent[i] = i;
            size[i] = 1;
        }
        int waterNum=0;
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                if(grid[i][j]==1 && !visited[i][j]){
                    bfs(i,j,visited,grid);
                }
                if(grid[i][j]==0) waterNum++;
            }
        }
        if(waterNum==0) return m*n;
        int ans = 0;
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                if(grid[i][j]==0){
                    HashSet<Integer> rootSet = new HashSet<>();
                    int tmp = 1;
                    if(i-1>=0 && i-1<m && j>=0 && j<n && grid[i-1][j]==1 && !rootSet.contains(parent[(i-1)*n+j])){
                        rootSet.add(parent[(i-1)*n+j]);
                        tmp+=size[parent[(i-1)*n+j]];
                    }
                    if(i+1>=0 && i+1<m && j>=0 && j<n && grid[i+1][j]==1 && !rootSet.contains(parent[(i+1)*n+j])){
                        rootSet.add(parent[(i+1)*n+j]);
                        tmp+=size[parent[(i+1)*n+j]];
                    }
                    if(i>=0 && i<m && j-1>=0 && j-1<n && grid[i][j-1]==1 && !rootSet.contains(parent[i*n+j-1])){
                        rootSet.add(parent[i*n+j-1]);
                        tmp+=size[parent[i*n+j-1]];
                    }
                    if(i>=0 && i<m && j+1>=0 && j+1<n && grid[i][j+1]==1 && !rootSet.contains(parent[i*n+j+1])){
                        rootSet.add(parent[i*n+j+1]);
                        tmp+=size[parent[i*n+j+1]];
                    }
                    ans = Math.max(ans,tmp);
                }
            }
        }
        return ans;
    }
    public static void bfs(int i,int j,boolean[][] visited,int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int entry = i*n+j;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i,j});
        visited[i][j] = true;
        System.out.println("Added: "+i+","+j);
        while(!q.isEmpty()){
            int sz = q.size();
            for(int k=0;k<sz;++k){
                int[] item = q.poll();
                int row = item[0],col = item[1];
                System.out.println("Polled: "+row+","+col);
                if(row-1>=0 && row-1<m && col>=0 && col<n && grid[row-1][col]==1){
                    if(!visited[row-1][col]){
                        q.offer(new int[]{row-1,col});
                        visited[row-1][col] = true;
                        parent[(row-1)*n+col] = entry;
                        size[entry]++;
                        System.out.println("Added: "+(row-1)+","+col);
                    }
                }
                if(row+1>=0 && row+1<m && col>=0 && col<n && grid[row+1][col]==1) {
                    if(!visited[row+1][col]){
                        q.offer(new int[]{row+1,col});
                        visited[row+1][col] = true;
                        parent[(row+1)*n+col] = entry;
                        size[entry]++;
                        System.out.println("Added: "+(row+1)+","+col);
                    }
                }
                if(row>=0 && row<m && col-1>=0 && col-1<n && grid[row][col-1]==1) {
                    if(!visited[row][col-1]){
                        q.offer(new int[]{row,col-1});
                        visited[row][col-1] = true;
                        parent[row*n+col-1] = entry;
                        size[entry]++;
                        System.out.println("Added: "+(row)+","+(col-1));
                    }
                }
                if(row>=0 && row<m && col+1>=0 && col+1<n && grid[row][col+1]==1){
                    if(!visited[row][col+1]){
                        q.offer(new int[]{row,col+1});
                        visited[row][col+1] = true;
                        parent[row*n+col+1] = entry;
                        size[entry]++;
                        System.out.println("Added: "+(row)+","+(col+1));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] map1 = { { 0, 1, 0, 0, 1, 1 }, { 1, 1, 1, 0, 0, 0 }, { 1, 1, 0, 1, 1, 0 }, { 1, 1, 0, 0, 1, 0 }, };
        int[][] map2 = {{1,0},{0,1}};
        int[][] map3 = {{1,1},{1,0}};
        int[][] map4 = {{1,1},{1,1}};
        int ans = largestIsland(map4);

        System.out.println("--------------------");
        System.out.println(ans);
    }
}
