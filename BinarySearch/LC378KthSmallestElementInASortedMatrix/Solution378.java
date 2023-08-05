package BinarySearch.LC378KthSmallestElementInASortedMatrix;

public class Solution378 {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length, left = matrix[0][0], right = matrix[n-1][n-1];
        if(k==1)    return left;
        if(k==n*n)  return right;
        while(left+1<right){
            int mid = left+(right-left)/2;
            if(countLessThan(matrix,mid)>=k)    right = mid;//实际的kth element一定小于mid
            else    left = mid;//实际的kth element一定大于等于mid
        }
        return countLessThan(matrix,right)==k-1?right:left;
    }
    public int countLessThan(int[][] matrix,int target){
        int cnt = 0, i=matrix.length-1, j=0;
        while(i>=0 && j<matrix[0].length){
            if(matrix[i][j]<target){
                cnt += i+1;
                j++;
            }else  i--;
        }
        return cnt;
    }
}
