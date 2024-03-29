package BinarySearch.LC74SearchA2DMatrix;

public class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m*n-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(matrix[mid/n][mid%n]==target) return true;
            else if(matrix[mid/n][mid%n]>target) right = mid-1;
            else if(matrix[mid/n][mid%n]<target) left = mid+1;
        }
        return false;
    }
}
