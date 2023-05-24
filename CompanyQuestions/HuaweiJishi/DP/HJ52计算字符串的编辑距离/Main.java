package CompanyQuestions.HuaweiJishi.DP.HJ52计算字符串的编辑距离;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;++i)   dp[i][0] = i;
        for(int j=0;j<=n;++j)   dp[0][j] = j;
        for(int i=1;i<=m;++i){
            for(int j=1;j<=n;++j){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j]+1,dp[i][j-1]+1));
                }else{
                    dp[i][j] = Math.min(dp[i-1][j-1]+1,Math.min(dp[i-1][j]+1,dp[i][j-1]+1));
                }
            }
        }
        System.out.println(dp[m][n]);
    }
}
