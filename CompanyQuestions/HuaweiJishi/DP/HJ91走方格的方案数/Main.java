package CompanyQuestions.HuaweiJishi.DP.HJ91走方格的方案数;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt()+1;
        int m = in.nextInt()+1;
        int[][] dp = new int[n][m];
        dp[n-1][m-1] = 1;
        for(int col = 0;col<m;++col){
            dp[n-1][col] = 1;
        }
        for(int row = 0;row<n;++row){
            dp[row][m-1] = 1;
        }
        for(int row = n-2;row>=0;--row){
            for(int col = m-2;col>=0;--col){
                dp[row][col] = dp[row][col+1] + dp[row+1][col];
            }
        }
        System.out.println(dp[0][0]);
    }
}
