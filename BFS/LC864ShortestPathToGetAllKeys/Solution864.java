package BFS.LC864ShortestPathToGetAllKeys;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution864 {
    public int shortestPathAllKeys(String[] grid) {
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};//down,up,right,left
        int m = grid.length;
        int n = grid[0].length();
        char[][] g = new char[m][n];
        int[] start = new int[2];
        int allKeys = 0;
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                g[i][j] = grid[i].charAt(j);
                if(isKey(g[i][j])){
                    allKeys += (1<<(g[i][j]-'a'));
                }else if(g[i][j]=='@'){
                    start[0] = i;
                    start[1] = j;
                }
            }
        }
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{start[0],start[1],0,0});//[row, column, key state, distance]
        boolean[][][] visited = new boolean[allKeys+1][m][n];
        visited[0][start[0]][start[1]] = true;
        while(!q.isEmpty()){
            int[] u = q.poll();
            int state = u[2],moves = u[3];
            for(int[] dir:dirs){
                int row = u[0]+dir[0], col = u[1]+dir[1];
                if(row>=0 && col>=0 && row<m && col<n && g[row][col]!='#'){
                    if(isLock(g[row][col]) && (state & (1<<(g[row][col]-'A')))==0){
                        continue;
                    }
                    int newState = state;
                    if(isKey(g[row][col])){
                        newState = (state | (1<<(g[row][col]-'a')));
                        if(newState==allKeys)   return moves+1;
                    }
                    if(!visited[newState][row][col]){ //could be an empty cell or a lock with corresponding key
                        visited[newState][row][col] = true;
                        q.offer(new int[]{row,col,newState,moves+1});
                    }
                }
            }
        }
        return -1;
    }
    private boolean isLock(char c){return (c-'A'>=0 && c-'Z'<=0);}
    private boolean isKey(char c){return (c-'a'>=0 && c-'z'<=0);}
}
