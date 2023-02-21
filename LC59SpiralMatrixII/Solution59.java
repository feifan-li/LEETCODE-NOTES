package LC59SpiralMatrixII;

public class Solution59 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int num = 1;
        int rowBegin = 0, rowEnd = n-1;
        int colBegin = 0, colEnd = n-1;
        while(rowBegin<=rowEnd && colBegin<=colEnd){
            for(int i=colBegin;i<=colEnd;++i){
                res[rowBegin][i] = num;
                ++num;
            }
            ++rowBegin;
            for(int i=rowBegin;i<=rowEnd;++i){
                res[i][colEnd] = num;
                ++num;
            }
            --colEnd;
            if(rowBegin<=rowEnd){
                for(int i=colEnd;i>=colBegin;--i){
                    res[rowEnd][i] = num;
                    num++;
                }
            }
            --rowEnd;
            if(colBegin<=colEnd){
                for(int i=rowEnd;i>=rowBegin;--i){
                    res[i][colBegin] = num;
                    num++;
                }
            }
            ++colBegin;
        }
        return res;
    }
}
