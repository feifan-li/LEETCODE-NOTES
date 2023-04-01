package DynamicProgramming.LC1444NumberOfWaysOfCuttingAPizza;

public class Solution1444 {
    public static int ways(String[] pizza, int k) {
        final int mod = 1000000007;
        int m = pizza.length;
        int n = pizza[0].length();
        int[][] sum = new int[m+1][n+1];//left-top is (i,j),right-bottom is (m-1,n-1)
        for(int i=m-1;i>=0;--i){
            for(int j=n-1;j>=0;--j){
                if(pizza[i].charAt(j)=='A') sum[i][j] = 1;
                sum[i][j] += sum[i+1][j]+sum[i][j+1]-sum[i+1][j+1];
            }
        }
        int[][][] dp = new int[m+1][n+1][k];//0 cuts ~ k-1 cuts
        for(int i=m-1;i>=0;--i){
            for(int j=n-1;j>=0;--j){
                dp[i][j][0] = sum[i][j]>0?1:0;
                for(int cuts=1;cuts<k;++cuts){
                    //横着切
                    for(int row=i+1;row<m;++row){
                        if(sum[i][j]-sum[row][j]>0){
                            dp[i][j][cuts] = (dp[i][j][cuts]+dp[row][j][cuts-1])%mod;
                        }
                    }
                    //竖着切
                    for(int col = j+1;col<n;++col){
                        if(sum[i][j]-sum[i][col]>0){
                            dp[i][j][cuts] = (dp[i][j][cuts]+dp[i][col][cuts-1])%mod;
                        }
                    }
                }
            }
        }
        return dp[0][0][k-1];
    }
    public static void main(String[] args) {
        System.out.println(ways(new String[]{"A..","AAA","..."},3));
        System.out.println(ways(new String[]{"A..","AA.","..."},3));
        System.out.println(ways(new String[]{"A..","A..","..."},1));
        System.out.println(ways(new String[]{".A","AA","A."},3));
    }
}
