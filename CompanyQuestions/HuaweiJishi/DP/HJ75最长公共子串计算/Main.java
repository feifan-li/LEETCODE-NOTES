package CompanyQuestions.HuaweiJishi.DP.HJ75最长公共子串计算;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        int m = s1.length();
        int n = s2.length();
        int ans = 0;
        //T(n) = O(mn)  S(n) = O(mn)
         int[][] dp = new int[m+1][n+1];
         for(int i=1;i<=m;++i){
             for(int j=1;j<=n;++j){
                 dp[i][j] = s1.charAt(i-1)==s2.charAt(j-1)?dp[i-1][j-1]+1:0;
                 ans = Math.max(ans,dp[i][j]);
             }
         }

        //T(n) = O(n*m^2) S(n) = O(1)
//        for(int i=0;i<s1.length();++i){
//            for(int j=0;j<=i;++j){
//                if(s2.contains(s1.substring(j,i+1))){
//                    ans = Math.max(ans,i-j+1);
//                    break;
//                }
//            }
//        }

        System.out.println(ans);
    }
}
