package DynamicProgramming.LC741CherryPickUp;

import java.util.Arrays;

public class Solution741 {
    public static int cherryPickup(int[][] grid) {
        int n = grid.length;
        //r1+c1 = r2+c2 = k, where k belongs to range [0,2*n-2]
        int[][][] dp = new int[n][n][2*n-1];//dp[r1][c1][r2][c2] can be reduced to 3 dimesion: dp[r1][r2][k]
        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                Arrays.fill(dp[i][j],Integer.MIN_VALUE);
            }
        }
        dp[0][0][0] = grid[0][0];
        for(int k=1;k<2*n-1;++k){
            for(int r1=Math.max(k+1-n,0);r1<=Math.min(k,n-1);++r1){
                int c1 = k-r1;//0 <= c1 <= n-1  ->  r1<=k && r1>=k+1-n
                if(grid[r1][c1]==-1)    continue;
                for(int r2=r1;r2<=Math.min(k,n-1);++r2){
                    int c2 = k-r2;
                    if(grid[r2][c2]==-1)    continue;
                    int res = dp[r1][r2][k-1];//both come from left,since r1
                    if(r1>0 && r2>0) res = Math.max(res,dp[r1-1][r2-1][k-1]);//both come from up
                    if(r2>0) res = Math.max(res,dp[r1][r2-1][k-1]);//1st one come from left, 2nd one come from up
                    if(r1>0) res = Math.max(res,dp[r1-1][r2][k-1]);//1st one come from up, 2nd one come from left
                    res += grid[r1][c1];
                    if(r1!=r2) res += grid[r2][c2];
                    dp[r1][r2][k] = res;
                }
            }
        }
        return dp[n-1][n-1][2*n-2]<0?0:dp[n-1][n-1][2*n-2];
    }
    public static void printArray(int[][] a){
        for(int i=0;i<a.length;++i){
            for(int j=0;j<a[0].length;++j){
                System.out.print(a[i][j]+", ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        System.out.println(cherryPickup(new int[][]{{1,1,1},{1,1,1},{1,1,1}}));
        System.out.println(cherryPickup(new int[][]{{1, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 1}, {1, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 1, 1, 1}}));
        System.out.println(cherryPickup(new int[][]{{0, 1, -1}, {1, 0, -1}, {1, 1, 1}}));
        System.out.println(cherryPickup(new int[][]{{1, 1, -1}, {1, -1, 1}, {-1, 1, 1}}));
    }
}
