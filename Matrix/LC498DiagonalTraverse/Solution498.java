package Matrix.LC498DiagonalTraverse;

public class Solution498 {
    public int[] findDiagonalOrder(int[][] mat) {
        int[][] dirs = new int[][]{{-1,1},{1,-1}};
        int m = mat.length, n = mat[0].length, DIR = 0,i = 0,j = 0,index = 0;
        int[] ans = new int[m*n];
        while(i>=0 && j>=0 && i<m && j<n){
            ans[index++] = mat[i][j];
            int next_i = i+dirs[DIR][0], next_j = j+dirs[DIR][1];
            if(next_i>=0 && next_j>=0 && next_i<m && next_j<n){
                i = next_i;
                j = next_j;
            }else if(DIR==0){
                if(next_j>=0 && next_j<n)     j = next_j;
                else if(i+1>=0 && i+1<m)      i = i+1;
                else    break;
                DIR = 1;
            }else if(DIR==1){
                if(next_i>=0 && next_i<m)    i = next_i;
                else if(j+1>=0 && j+1<n)     j = j+1;
                else    break;
                DIR = 0;
            }
        }
        return ans;
    }
}
