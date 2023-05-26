package CompanyQuestions.HuaweiJishi.DP.HJ61放苹果;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        if(m==0 || m==1)    System.out.println(1);
        else if(n==1)   System.out.println(1);
        else{
            int[][][] dp = new int[m+1][n+1][m+1];
            for(int i=1;i<=m;++i){
                dp[i][1][i] = 1;//只有一个盘子不为空的放法
            }
            for(int i=2;i<=m;++i){
                for(int j=2;j<=Math.min(i,n);++j){
                    for(int min = 1;min <= i/j;min++){
                        for(int submin = min;submin<= (i-min)/(j-1);submin++){
                            dp[i][j][min] += dp[i-min][j-1][submin];
                        }
                    }
                }
            }
            int ans = dp[m][1][m];
            for(int j=2;j<=Math.min(m,n);++j){
                for(int min = 1;min<=m/j;++min){
                    ans+=dp[m][j][min];
                }
            }
            System.out.println(ans);
        }
    }
}
