package Backtrack.LC51NQueens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution51 {
    List<List<String>> res= new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i=0;i<n;++i)    Arrays.fill(board[i],'.');
        backtrack(board,0);
        return res;
    }
    public void backtrack(char[][] board, int row){
        if(row == board.length){
            List<String> list = new ArrayList<>();
            for(int i=0;i<board.length;++i) list.add(String.valueOf(board[i]));
            res.add(list);
            return;
        }
        for(int col = 0;col<board.length;col++){
            if(isValid(board,row,col)){
                board[row][col] = 'Q';
                backtrack(board,row+1);
                board[row][col] = '.';
            }
        }
    }
    public boolean isValid(char[][] board, int row, int col){
        int n = board.length;
        //should not on same column
        for(int i=0;i<row;++i){
            if(board[i][col]=='Q') return false;
        }
        //should not on same row, but when backtracking this won't happen
        //should not on same diagonal
        for(int i=row-1,j=col+1;i>=0 && j<n;i--,j++){
            if(board[i][j]=='Q') return false;
        }
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q') return false;
        }
        return true;
    }
}
