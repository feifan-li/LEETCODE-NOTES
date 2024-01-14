package Matrix.LC311SparseMatrixMultiplication;

public class Solution311 {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int M = mat1.length;
        int K= mat1[0].length;
        assert mat2.length==K;
        int N = mat2[0].length;
        int[][] res = new int[M][N];
        for(int i=0;i<M;++i){
            for(int k=0;k<K;++k){
                if(mat1[i][k]!=0){
                    for(int j=0;j<N;++j){
                        if(mat2[k][j]!=0)   res[i][j] += mat1[i][k]*mat2[k][j];
                    }
                }
            }
        }
        return res;
    }
}
