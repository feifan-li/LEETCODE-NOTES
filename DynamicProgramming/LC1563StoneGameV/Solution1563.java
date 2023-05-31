package DynamicProgramming.LC1563StoneGameV;

import java.util.Arrays;

public class Solution1563 {
    public int stoneGameV(int[] vals) {
        int n = vals.length;
        int[] sum = new int[n];
        sum[0] = vals[0];
        for(int i=1;i<n;++i){
            sum[i] = sum[i-1]+vals[i];
        }
        int[][] memo = new int[n][n];
        for(int i=0;i<n;++i){
            Arrays.fill(memo[i],-1);
            memo[i][i] = 0;
        }
        return dc(vals,sum,memo,0,n-1);
    }
    public int dc(int[] vals,int[] sum,int[][] memo,int left,int right){
        if(left==right) return 0;
        if(memo[left][right]!=-1)   return memo[left][right];
        int max = -1;
        for(int i=left;i<right;++i){
            int leftScore = left==0?sum[i]:sum[i] - sum[left-1];
            int rightScore = sum[right]-sum[i];
            if(leftScore<rightScore){
                max = Math.max(max,leftScore+dc(vals,sum,memo,left,i));
            }else if(rightScore<leftScore){
                max = Math.max(max,rightScore+dc(vals,sum,memo,i+1,right));
            }else{
                max = Math.max(max,leftScore+Math.max(dc(vals,sum,memo,left,i),dc(vals,sum,memo,i+1,right)));
            }
        }
        memo[left][right] = max;
        return max;
    }
}
