package BFS.LC1254NumberOfClosedIslands;

import java.util.LinkedList;
import java.util.Queue;

public class Solution1254 {
    public static boolean[][] visited;
    public static int closedIsland(int[][] g) {
        int ans = 0;
        int m = g.length;
        int n = g[0].length;
        if(m==1 || n==1) return 0;
        visited = new boolean[m][n];
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                if(g[i][j]==0 && !visited[i][j]){
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i,j});
                    visited[i][j] = true;
                    boolean isClosed = bfs(g,q);
                    ans += (isClosed?1:0);
                }else continue;
            }
        }
        return ans;
    }
    private static boolean bfs(int[][] g, Queue<int[]> q){
        boolean isClosed = true;
        while(!q.isEmpty()){
            int size = q.size();
            for(int cnt=0;cnt<size;++cnt){
                int[] s = q.poll();
                int i = s[0],j=s[1];
                /**UP**/
                if(i-1>=0 && g[i-1][j]==0 && !visited[i-1][j]){
                    q.offer(new int[]{i-1,j});
                    visited[i-1][j] = true;
                }else if(i-1<0) isClosed = false;
                /**LEFT**/
                if(j-1>=0 && g[i][j-1]==0 && !visited[i][j-1]){
                    q.offer(new int[]{i,j-1});
                    visited[i][j-1] = true;
                }else if(j-1<0) isClosed = false;
                /**RIGHT**/
                if(j+1<g[0].length && g[i][j+1]==0 && !visited[i][j+1]){
                    q.offer(new int[]{i,j+1});
                    visited[i][j+1] = true;
                }else if(j+1>=g[0].length) isClosed = false;
                /**DOWN**/
                if(i+1<g.length && g[i+1][j]==0 && !visited[i+1][j]){
                    q.offer(new int[]{i+1,j});
                    visited[i+1][j] = true;
                }else if(i+1>=g.length) isClosed = false;
            }
        }
        return isClosed;
    }

    public static void main(String[] args) {
        System.out.println(closedIsland(new int[][]{{1, 1, 1, 1, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 1, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 0}}));
        System.out.println(closedIsland(new int[][]{{0, 0, 1, 0, 0}, {0, 1, 0, 1, 0}, {0, 1, 1, 1, 0}}));
        System.out.println(closedIsland(new int[][]{{1, 1, 1, 1, 1, 1, 1},
                                                    {1, 0, 0, 0, 0, 0, 1},
                                                    {1, 0, 1, 1, 1, 0, 1},
                                                    {1, 0, 1, 0, 1, 0, 1},
                                                    {1, 0, 1, 1, 1, 0, 1},
                                                    {1, 0, 0, 0, 0, 0, 1},
                                                    {1, 1, 1, 1, 1, 1, 1}}));
    }
}
