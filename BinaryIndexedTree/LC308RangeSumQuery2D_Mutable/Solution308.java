package BinaryIndexedTree.LC308RangeSumQuery2D_Mutable;

public class Solution308 {
    class NumMatrix {
        public int[][] a;
        public int[][] tree;
        public int m;
        public int n;
        public NumMatrix(int[][] matrix) {
            m = matrix.length;
            n = matrix[0].length;
            a = new int[m][n];
            tree = new int[m+1][n+1];
            for(int i=0;i<m;++i){
                for(int j=0;j<n;++j){
                    update(i,j,matrix[i][j]);
                }
            }
        }
        public int lowbit(int i){
            return (-i)&i;
        }
        public void update(int row, int col, int val) {
            int delta = val - a[row][col];
            a[row][col] = val;
            for(int i=row+1;i<=m;i += lowbit(i)){
                for(int j=col+1;j<=n;j += lowbit(j)){
                    tree[i][j] += delta;
                }
            }
        }
        public int sum(int row,int col){//matrix[0][0] + ... + matrix[row-1][col-1]
            int ans = 0;
            for(int i=row;i>0;i -= lowbit(i)){
                for(int j=col;j>0;j -= lowbit(j)){
                    ans += tree[i][j];
                }
            }
            return ans;
        }
        public int sumRegion(int row1, int col1, int row2, int col2) {
            return sum(row2+1,col2+1)+sum(row1,col1)-sum(row1,col2+1)-sum(row2+1,col1);
        }
    }

    public static void main(String[] args) {
        /**
         * Your NumMatrix object will be instantiated and called as such:
         * NumMatrix obj = new NumMatrix(matrix);
         * obj.update(row,col,val);
         * int param_2 = obj.sumRegion(row1,col1,row2,col2);
         */
    }
}
