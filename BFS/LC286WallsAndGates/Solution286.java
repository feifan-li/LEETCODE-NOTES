package BFS.LC286WallsAndGates;

import java.util.LinkedList;
import java.util.Queue;

public class Solution286 {
    public void wallsAndGates(int[][] rooms) {
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        int m = rooms.length;
        int n = rooms[0].length;
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                if(rooms[i][j] == 0){
                    int steps = 1;
                    boolean[][] visited = new boolean[m][n];
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i,j});
                    visited[i][j] = true;
                    while(!q.isEmpty()){
                        int sz = q.size();
                        for(int cnt = 0;cnt<sz;++cnt){
                            int[] u = q.poll();
                            for(int[] dir:dirs){
                                if(u[0]+dir[0]>=0 && u[0]+dir[0]<m && u[1]+dir[1]>=0 && u[1]+dir[1]<n &&
                                        rooms[u[0]+dir[0]][u[1]+dir[1]]>steps && !visited[u[0]+dir[0]][u[1]+dir[1]]){
                                    q.offer(new int[]{u[0]+dir[0],u[1]+dir[1]});
                                    visited[u[0]+dir[0]][u[1]+dir[1]] = true;
                                    rooms[u[0]+dir[0]][u[1]+dir[1]] = steps;
                                }
                            }
                        }
                        steps++;
                    }
                }
            }
        }
    }
}
