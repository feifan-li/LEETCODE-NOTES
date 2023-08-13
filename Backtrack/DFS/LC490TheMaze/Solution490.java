package Backtrack.DFS.LC490TheMaze;

public class Solution490 {
    public int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public boolean hasPath(int[][] maze, int[] s, int[] dst) {
        int m = maze.length, n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        //can only "stop" at dst, can't just pass through
        visited[s[0]][s[1]] = true;
        return dfs(maze,visited,s,dst,m,n);
    }
    public boolean dfs(int[][] maze,boolean[][] visited,int[] s,int[] dst,int m,int n){
        //hit a wall, first stop to check whether the ball is at dst
        if(s[0]==dst[0] && s[1]==dst[1])    return true;
        //must change a direction
        for(int dir=0;dir<4;++dir){
            int row = s[0]+dirs[dir][0], col = s[1]+dirs[dir][1];
            while(row>=0 && col>=0 && row<m && col<n && maze[row][col]==0){
                row += dirs[dir][0];
                col += dirs[dir][1];
            }
            //now ball should change direction
            if(!visited[row-dirs[dir][0]][col-dirs[dir][1]]){
                visited[row-dirs[dir][0]][col-dirs[dir][1]] = true;
                if(dfs(maze,visited,new int[]{row-dirs[dir][0],col-dirs[dir][1]},dst,m,n))    return true;
            }
        }
        return false;
    }
}
