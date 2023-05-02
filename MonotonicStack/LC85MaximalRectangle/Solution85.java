package MonotonicStack.LC85MaximalRectangle;

public class Solution85 {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] mat = new int[n];
        int ans = 0;
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                mat[j] = matrix[i][j]=='0'?0:mat[j]+1;
            }
            ans = Math.max(ans,getMaxArea(mat));
        }
        return ans;
    }
    public int getMaxArea(int[] nums){
        int[] stack = new int[nums.length];
        int top = -1;
        int maxArea = 0;
        for(int i=0;i<nums.length;++i){
            while(top!=-1 && nums[i]<=nums[stack[top]]){
                int height = nums[stack[top--]];
                int leftLess = top==-1?-1:stack[top];
                maxArea = Math.max(maxArea,height*(i-leftLess-1));
            }
            stack[++top] = i;
        }
        while(top!=-1){
            int height = nums[stack[top--]];
            int leftLess = top==-1?-1:stack[top];
            maxArea = Math.max(maxArea,height*(nums.length-leftLess-1));
        }
        return maxArea;
    }
}
