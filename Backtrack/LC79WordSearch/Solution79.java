package Backtrack.LC79WordSearch;

public class Solution79 {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        if(m*n<word.length()) return false;
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                if(board[i][j]==word.charAt(0) && backtrack(board,word,i,j,0)) return true;
            }
        }
        return false;
    }
    private boolean backtrack(char[][] board,String word,int row,int col,int index){
        if(index>=word.length()) return true;
        if(row<0 || row>=board.length || col<0 || col>=board[0].length) return false;
        if(board[row][col] == word.charAt(index)){
            char cur = board[row][col];
            board[row][col] = '*';//visited
            boolean ans = backtrack(board,word,row+1,col,index+1) ||
                    backtrack(board,word,row-1,col,index+1) ||
                    backtrack(board,word,row,col+1,index+1) ||
                    backtrack(board,word,row,col-1,index+1);
            board[row][col] = cur;//restore
            return ans;
        }
        return false;
    }
}
