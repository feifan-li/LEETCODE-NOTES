package PrefixSum.LC1074NumberOfSubmatricesThatSumToTarget;

import java.util.HashMap;

public class Solution1074 {
    public int numSubmatrixSumTarget(int[][] mat, int target) {
        int m = mat.length, n = mat[0].length;
        //compute prefix sum: O(mn)
        int[][] p = new int[m][n];
        p[0][0] = mat[0][0];
        for(int j=1;j<n;++j){
            p[0][j] = p[0][j-1] + mat[0][j];
        }
        for(int i=1;i<m;++i){
            p[i][0] = p[i-1][0] + mat[i][0];
        }
        for(int i=1;i<m;++i){
            for(int j=1;j<n;++j){
                p[i][j] = p[i-1][j] + p[i][j-1] - p[i-1][j-1] + mat[i][j];
            }
        }
        int count = 0;
        HashMap<Integer,Integer> sumCnt = new HashMap<>();
        //reduce to 1D: O(m*m*n)
        for(int row1 = 0;row1<m;++row1){
            for(int row2 = row1;row2<m;++row2){
                sumCnt.clear();
                sumCnt.put(0,1);
                for(int col = 0;col < n;++col){
                    int cur = p[row2][col]-(row1==0?0:p[row1-1][col]);
                    count += sumCnt.getOrDefault(cur-target,0);
                    sumCnt.put(cur,sumCnt.getOrDefault(cur,0)+1);
                }
            }
        }
        return count;
    }
}
