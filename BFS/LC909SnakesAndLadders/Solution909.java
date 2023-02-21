package BFS.LC909SnakesAndLadders;

import java.util.LinkedList;
import java.util.Queue;

public class Solution909 {
    public static int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[][] label = new int[n][n];
        int[][] labelToIdx = new int[n*n+1][2];
        int count = 1;
        for(int i=n-1;i>=0;--i) {
            if (i % 2 == (n - 1) % 2) {
                for (int j = 0; j < n; ++j) {
                    label[i][j] = count;
                    count++;
                }
            } else {
                for (int j = n - 1; j >= 0; --j) {
                    label[i][j] = count;
                    count++;
                }
            }
        }
        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                labelToIdx[label[i][j]][0] = i;
                labelToIdx[label[i][j]][1] = j;
            }
        }
        //BFS
        Queue<int[]> q = new LinkedList<int[]>();
        q.offer(new int[]{1,0});//label 0, moves 0
        boolean[] visited = new boolean[n*n+1];//visited labels
        visited[1] = true;
        while(!q.isEmpty()){
            int[] node = q.poll();
            for(int i=1;i<=6;++i){
                int nextLabel = node[0]+i;
                if(nextLabel>n*n) break;
                int nextX = labelToIdx[nextLabel][0];
                int nextY = labelToIdx[nextLabel][1];
                if(board[nextX][nextY]!=-1){
                    nextLabel = board[nextX][nextY];
                }
                if(nextLabel==n*n) return node[1]+1;//返回的是最先到达终点的路径
                if(!visited[nextLabel]){
                    visited[nextLabel]=true;
                    q.offer(new int[]{nextLabel,node[1]+1});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] board1 = {{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,35,-1,-1,13,-1},
                {-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}};
        int[][] board2 = {{-1,-1},{-1,3}};
        System.out.println(snakesAndLadders(board1));
        System.out.println(snakesAndLadders(board2));
    }
}
