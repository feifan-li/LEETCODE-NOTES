package CumulativeSum.LC304RangeSumQuery2D_Immutable;

public class Solution304 {
    //二维前缀和
    static class NumMatrix {
        private int[][] sum;
        public NumMatrix(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            this.sum = new int[m+1][n+1];
            for(int i=1;i<=m;++i){
                for(int j=1;j<=n;++j){
                    sum[i][j] = matrix[i-1][j-1]+sum[i][j-1]+sum[i-1][j]-sum[i-1][j-1];
                }
            }
        }
        //must work on O(1):
        public int sumRegion(int row1, int col1, int row2, int col2) {
            return sum[row2+1][col2+1] - sum[row1][col2+1] - sum[row2+1][col1] + sum[row1][col1];
        }
    }

    public static void main(String[] args) {

    }
}
