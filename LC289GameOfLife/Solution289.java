package LC289GameOfLife;

public class Solution289 {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] origin = new int[m][n];
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                origin[i][j] = board[i][j];
            }
        }
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1},{-1,-1},{1,1},{1,-1},{-1,1}};
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                int cnt = 0;
                for(int[] dir:dirs){
                    if(i+dir[0]>=0 && i+dir[0]<m && j+dir[1]>=0 && j+dir[1]<n && origin[i+dir[0]][j+dir[1]]==1){
                        cnt++;
                    }
                }
                if(board[i][j]==1 && (cnt<2 || cnt>3))   board[i][j] = 0;
                if(board[i][j]==0 && cnt==3)    board[i][j] = 1;
            }
        }
    }
}
