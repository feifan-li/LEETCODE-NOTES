package DivideAndConquer.LC1569NumberOfWaysToReorderArrayToGetSameBST;

public class Solution1569 {
    public long MOD = (long)(1e9+7);
    public long[][] NChooseK;//is a table of Pascal's triangle
    public int numOfWays(int[] nums) {
        NChooseK = new long[nums.length][nums.length];
        for(int N = 0;N<nums.length;++N)    NChooseK[N][0] = NChooseK[N][N] = 1;
        for(int N = 2;N<nums.length;++N){
            for(int k=1;k<N;++k)    NChooseK[N][k] = (NChooseK[N-1][k-1] + NChooseK[N-1][k])%MOD;
        }
        return (int)((dc(nums,nums.length)-1)%MOD);
    }
    public long dc(int[] nums,int n){
        if(n==0 || n==1 || n==2)    return 1L;
        int leftLen = 0, rightLen = 0;
        int[] left = new int[n];
        int[] right = new int[n];
        for(int i=1;i<n;++i){
            if(nums[i]<nums[0])         left[leftLen++] = nums[i];
            else if(nums[i]>nums[0])    right[rightLen++] = nums[i];
        }
        long leftRes = dc(left,leftLen)%MOD;
        long rightRes = dc(right,rightLen)%MOD;
        return (NChooseK[n-1][leftLen]*((leftRes*rightRes)%MOD))%MOD;
    }
}
