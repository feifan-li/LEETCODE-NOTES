package BinarySearch.LC1351CountNegativeNumbersinaSortedMatrix;

public class Solution1351 {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0,left = 0, right = n-1,colRight = n-1;
        for(int i=0;i<m;++i){
            //search first neg
            left = 0;
            right = colRight;
            while(left<=right){
                int mid = left + (right-left)/2;
                if(grid[i][mid]>=0) left = mid+1;
                else    right = mid-1;
            }
            ans += (m-i)*(colRight-left+1);
            colRight = left-1;
        }
        return ans;
    }
}
