package Graph.Dijkstras.LC505TheMazeII;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution505_2 {
    /*** Dijkstra's Algorithm*/
    public int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int shortestDistance(int[][] maze, int[] start, int[] dst) {
        int m = maze.length, n = maze[0].length;
        int[][] dist = new int[m][n];
        for(int[] distRow:dist) Arrays.fill(distRow,999999);
        dist[start[0]][start[1]] = 0;//exclude the start position
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->(a[2]-b[2]));
        pq.offer(new int[]{start[0],start[1],0});
        while(!pq.isEmpty()){
            int[] s = pq.poll();
            if(dist[s[0]][s[1]]<s[2])   continue;//old key, should already be decreased
            for(int[] dir:dirs){
                int x = s[0], y = s[1], dx = dir[0], dy = dir[1], cnt = 0;
                while(x+dx>=0 && y+dy>=0 && x+dx<m && y+dy<n && maze[x+dx][y+dy]==0){
                    x += dir[0];
                    y += dir[1];
                    cnt++;
                }
                if(dist[s[0]][s[1]]+cnt<dist[x][y]){
                    dist[x][y] = dist[s[0]][s[1]]+cnt;
                    pq.offer(new int[]{x,y,dist[x][y]});
                }
            }
        }
        return dist[dst[0]][dst[1]]==999999?-1:dist[dst[0]][dst[1]];
    }
}
