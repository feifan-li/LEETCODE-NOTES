package CompanyQuestions.HuaweiJishi.DP.最长递增子序列.HJ103Redraiment的走法;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;++i)    nums[i] = in.nextInt();
        int[] dp = new int[n];//dp[i]: a strictly-increasing seq of length i+1 ending with value dp[i]
        int right = 0;
        for(int i=0;i<nums.length;++i){
            int id = searchLeftMostGreaterOrEqual(dp,0,right,nums[i]);
            if(id==right)   right++;//no element greater or equal to target
            dp[id] = nums[i];
        }
        System.out.println(right);
    }
    public static int searchLeftMostGreaterOrEqual(int[] dp,int left,int right,int target){
        //[left,right)
        while(left<right){
            int mid = left+(right-left)/2;
            if(dp[mid]>=target)  right = mid;
            else    left = mid+1;
        }
        return right;
    }
}
