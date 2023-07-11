package OODesign.LC348DesignTicTacToe;

public class Solution348 {
    class TicTacToe {
        public int[][] board;
        public int n;
        public TicTacToe(int n) {
            this.n = n;
            this.board = new int[n][n];
        }

        public int move(int row, int col, int player) {
            this.board[row][col] = (player==1?1:-1);
            if(checkHorizontal(player, row, col) || checkVertical(player, row, col) || checkDiagonal(player, row, col)){
                return player==1?1:2;
            }
            return 0;
        }
        public boolean checkHorizontal(int player, int row, int col){
            for(int j=0;j<n;++j)    if(board[row][j]!=(player==1?1:-1)) return false;
            return true;
        }
        public boolean checkVertical(int player, int row, int col){
            for(int i=0;i<n;++i)    if(board[i][col]!=(player==1?1:-1)) return false;
            return true;
        }
        public boolean checkDiagonal(int player, int row, int col){
            if(!(row==col) && !(row+col==n-1))  return false;
            int sum1 = 0, sum2 = 0;
            for(int i=0;i<n;++i){
                sum1 += board[i][i];
                sum2 += board[i][n-1-i];
            }
            return (player==1 && (sum1==n || sum2==n)) || (player==2 && (sum1==-n || sum2==-n));
        }
    }
}
