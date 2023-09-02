package Matrix.LC48RotateImage;

public class Solution48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i=0;i<n;++i){
            for(int j=i+1;j<n;++j)  swap(matrix,i,j,j,i);
        }
        for(int i=0;i<n;++i){
            for(int j=0;j<n/2;++j)  swap(matrix,i,j,i,n-1-j);
        }
    }
    public void swap(int[][] matrix,int i,int j,int new_i,int new_j){
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[new_i][new_j];
        matrix[new_i][new_j] = tmp;
    }
}
