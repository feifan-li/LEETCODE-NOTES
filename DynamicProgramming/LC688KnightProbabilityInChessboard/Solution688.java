package DynamicProgramming.LC688KnightProbabilityInChessboard;

public class Solution688 {
    public double knightProbability(int n, int k, int row, int col) {
        int[][] dirs = new int[][]{{-2,-1},{2,-1},{-1,-2},{1,-2},{-2,1},{2,1},{-1,2},{1,2}};
        double[][][] dp = new double[n][n][k+1];//prob. of move to some position after some steps
        dp[row][col][0] = 1.0;//base case
        for(int step = 1;step<=k;++step){
            for(int i=0;i<n;++i){
                for(int j=0;j<n;++j){
                    for(int[] d:dirs){
                        if(i-d[0]>=0 && j-d[1]>=0 && i-d[0]<n && j-d[1]<n)  dp[i][j][step] += dp[i-d[0]][j-d[1]][step-1]/8.0;
                    }
                }
            }
        }
        if(k==0)    return 1.0;
        double ans = 0.0;
        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j)    ans += dp[i][j][k];
        }
        return ans;
    }
}
