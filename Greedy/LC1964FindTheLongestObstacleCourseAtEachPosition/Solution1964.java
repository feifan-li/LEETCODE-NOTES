package Greedy.LC1964FindTheLongestObstacleCourseAtEachPosition;

public class Solution1964 {
    public int[] longestObstacleCourseAtEachPosition(int[] heights) {
        int n = heights.length;
        int[] ans = new int[n];
        int[] dp = new int[n];//dp[i]: a non-dec seq of length i+1 ending with dp[i]
        //dp will also be non-dec
        int right = 0;
        for(int i=0;i<heights.length;++i){
            int height = heights[i];
            //只有高度<=height的子序列有用, 找到最长的这种子序列:
            int id = searchLeftMostGreater(dp,0,right,height);
            if(id==right){right ++;}
            dp[id] = height;// id左侧存在着高度<=height的子序列, 因为要以height结尾,
                            // 而id右侧代表的子序列长度大于height, 更改后dp数组仍然是非严格递增的
            ans[i] = id+1;
        }
        return ans;
    }
    private int searchLeftMostGreater(int[] nums,int left,int right,int k){
        //search within [left,right), return the id of such an element
        while(left<right){
            int mid = left + (right - left)/2;
            if(nums[mid]<=k) left = mid+1;
            else right = mid;
        }
        return left;
    }
}
