package CumulativeSum.LC2132StampingTheGrid;

public class Solution2132 {
    public static boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] sum = new int[m+1][n+1];
        for(int i=1;i<=m;++i){
            for(int j=1;j<=n;++j){
                sum[i][j] = grid[i-1][j-1];
            }
        }
        //二维前缀和
        cumulative(sum);//sum[i][j] = grid[0][0] + ... + grid[i-1][j-1]
        //二维差分
        //邮票贴在差分矩阵里
        int[][] diff = new int[m+2][n+2];//index start from 1
        for(int row1 = 1,row2 = row1+stampHeight-1;row2<=m;row1++,row2++){
            for(int col1 = 1,col2 = col1+stampWidth-1;col2<=n;col1++,col2++){
                if(empty(sum,row1,row2,col1,col2)){
                    //grid,row1-1,row2-1,col1-1,col2-1
                    set(diff,row1,row2,col1,col2);
                }
            }
        }
        cumulative(diff);
        //diff[i][j]:grid[i-1][j-1]被覆盖的次数
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && diff[i + 1][j + 1] == 0) {
                    return false;
                }
            }
        }
        return true;

    }
    public static void cumulative(int[][] mat){
        int m = mat.length;
        int n = mat[0].length;
        for(int i=1;i<m;++i){
            for(int j=1;j<n;++j){
                mat[i][j] += mat[i-1][j]+mat[i][j-1]-mat[i-1][j-1];
            }
        }
    }
    public static boolean empty(int[][] sum, int row1,int row2,int col1, int col2){
        return sum[row2][col2] - sum[row2][col1-1] - sum[row1-1][col2] + sum[row1-1][col1-1] == 0;
    }
    public static void set(int[][] diff,int row1,int row2,int col1, int col2){
        diff[row1][col1] += 1;
        diff[row2+1][col2+1] += 1;
        diff[row1][col2+1] -= 1;
        diff[row2+1][col1] -= 1;
    }

    public static void main(String[] args) {
        System.out.println(possibleToStamp(new int[][]{{1,0,0,0},{1,0,0,0},{1,0,0,0},{1,0,0,0},{1,0,0,0}},4,3));
        System.out.println(possibleToStamp(new int[][]{{1,0,0,0},{0,1,0,0},{0,0,1,0},{0,0,0,1}},2,2));
    }
}
