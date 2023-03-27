package DynamicProgramming.LC174DungeonGame;

public class Solution174 {
    /*Return the knight's minimum initial health so that he can rescue the princess.*/
    //health points should always be positive
    public static int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];//dp[i][j]:min HP when entering (i,j), so that can (i,j)->(m-1,n-1)
        //cannot dp from left top to bottom right, 不满足无后效性
        dp[m-1][n-1] = dungeon[m-1][n-1]>=0?1:1-dungeon[m-1][n-1];
        for(int row=m-2;row>=0;--row) dp[row][n-1] = Math.max(dp[row+1][n-1]-dungeon[row][n-1],1);
        for(int col = n-2;col>=0;--col) dp[m-1][col] = Math.max(dp[m-1][col+1]-dungeon[m-1][col],1);
        for(int row = m-2;row>=0;--row){
            for(int col = n-2;col>=0;--col){
                dp[row][col] = Math.max(Math.min(dp[row+1][col],dp[row][col+1])-dungeon[row][col],1);
            }
        }
        return dp[0][0];
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
        System.out.println(calculateMinimumHP(new int[][]{{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}}));
        System.out.println(calculateMinimumHP(new int[][]{{0}}));
        System.out.println(calculateMinimumHP(new int[][]{{3}}));
        System.out.println(calculateMinimumHP(new int[][]{{3,-20,30}, {-3, 4, 0}}));
        System.out.println(calculateMinimumHP(new int[][]{{1},{-2},{1}}));
        System.out.println(calculateMinimumHP(new int[][]{{1, -3, 3}, {0, -2, 0}, {-3, -3, -3}}));
    }
}
