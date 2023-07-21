package Backtrack.LC37SudokuSolver;

public class Solution37 {
    public void solveSudoku(char[][] board) {
        backtrack(board,0,0);
    }
    public boolean backtrack(char[][] board,int row,int col){
        if(col==9)  return backtrack(board,row+1,0);
        if(row==9)  return true;
        if(board[row][col] != '.')  return backtrack(board,row,col+1);
        for(char i='1';i<='9';++i){
            if(isValid(board,row,col,i)){
                board[row][col] = i;
                if(backtrack(board,row,col+1))  return true;
                board[row][col] = '.';
            }
        }
        return false;
    }
    public boolean isValid(char[][] board,int row, int col,char num){
        for(int i=0;i<9;++i){
            if(board[i][col]==num)  return false;
            if(board[row][i]==num)  return false;
            if(board[(row/3)*3+i/3][(col/3)*3+i%3]==num)    return false;
        }
        return true;
    }
}
