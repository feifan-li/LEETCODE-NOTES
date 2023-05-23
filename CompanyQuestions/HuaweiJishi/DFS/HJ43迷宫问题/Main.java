package CompanyQuestions.HuaweiJishi.DFS.HJ43迷宫问题;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int[][] maze = new int[m][n];
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                maze[i][j] = in.nextInt();
            }
        }
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        boolean[][] visited = new boolean[m][n];
        LinkedList<int[]> trace = new LinkedList<>();
        dfs(trace,new int[]{0,0},new int[]{m-1,n-1},maze,visited,dirs,m,n);
    }
    private static void dfs(LinkedList<int[]> trace,int[] start,int[] end,int[][] maze,boolean[][] visited,int[][] dirs,
                            int m,int n){
        trace.add(start);
        visited[start[0]][start[1]] = true;
        if(start[0]==end[0] && start[1]==end[1]){
            for(int i=0;i<trace.size();++i){
                int[] t = trace.get(i);
                System.out.println("("+t[0]+","+t[1]+")");
            }
            return;
        }
        for(int[] dir:dirs){
            if(start[0]+dir[0]>=0 && start[0]+dir[0]<m && start[1]+dir[1]>=0 && start[1]+dir[1]<n &&
                    maze[start[0]+dir[0]][start[1]+dir[1]]==0 && !visited[start[0]+dir[0]][start[1]+dir[1]]){
                dfs(trace,new int[]{start[0]+dir[0],start[1]+dir[1]},end,maze,visited,dirs,m,n);
            }
        }
        trace.removeLast();
    }
}
