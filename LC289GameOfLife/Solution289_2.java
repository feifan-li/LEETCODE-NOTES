package LC289GameOfLife;

public class Solution289_2 {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1},{-1,-1},{1,1},{1,-1},{-1,1}};
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                int cnt = 0;
                for(int[] dir:dirs){
                    if(i+dir[0]>=0 && i+dir[0]<m && j+dir[1]>=0 && j+dir[1]<n && (board[i+dir[0]][j+dir[1]]&1)==1){
                        cnt++;
                    }
                }
                if(board[i][j]==1 && (cnt==2 || cnt==3)) board[i][j] = 3;//01->11
                // else if(board[i][j]==1 && (cnt<2 || cnt>3))   board[i][j] = 1;//01->01
                else if(board[i][j]==0 && cnt==3)    board[i][j] = 2;//00->10
                // else board[i][j] = 0;//00->00
            }
        }
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                board[i][j] = board[i][j]>>1;
            }
        }
    }
}
