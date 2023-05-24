package CompanyQuestions.HuaweiJishi.Backtrack.HJ44Sudoku;

import java.util.Scanner;

public class Main {
    public static int[][] nums = new int[9][9];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for(int i=0;i<9;++i){
            for(int j=0;j<9;++j){
                nums[i][j] = in.nextInt();
            }
        }
        System.out.println(backtrack(0,0));
        for(int i=0;i<9;++i){
            for(int j=0;j<9;++j){
                System.out.print(nums[i][j]+" ");
            }
            System.out.println();
        }
    }
    private static boolean backtrack(int i,int j){
        if(j==9)    return backtrack(i+1,0);
        if(i==9)    return true;
        if(nums[i][j]!=0)   return backtrack(i,j+1);
        for(int a=1;a<=9;++a){
            if(!isValid(i,j,a))    continue;
            nums[i][j] = a;
            if(backtrack(i,j+1))   return true;
            nums[i][j] = 0;
        }
        return false;
    }
    private static boolean isValid(int row,int col,int a){
        for(int i=0;i<9;++i){
            if(nums[row][i]==a) return false;
            if(nums[i][col]==a) return false;
            if(nums[(row/3)*3+i/3][(col/3)*3+i%3]==a)   return false;
        }
        return true;
    }
}
