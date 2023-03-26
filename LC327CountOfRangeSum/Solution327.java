package LC327CountOfRangeSum;

public class Solution327 {
    //归并排序改写
    //以0位置结尾的子数组，有几个达标
    //以1位置结尾的子数组，有几个达标
    //……
    //以n-1位置结尾的子数组，有几个达标
    //以i位置结尾的子数组，求有几个达标子数组：
    //假设sum(0,i)=x,lower,upper，则该问题等价于求取sum(0,-1),sum(0,0),sum(0,1),...,sum(0,i-1)有多少个数落在[x-upper,x-lower]上
    //merge时还需要利用滑动窗口的技巧，这个窗口是不回退的，还需要正常的归并排序中的合并过程
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] sum = new long[nums.length];
        sum[0] = (long)nums[0];
        for(int i=1;i<nums.length;++i) sum[i] = (long)nums[i]+sum[i-1];
        return process(sum,0,nums.length-1,lower,upper);
    }
    private int process(long[] sum,int l,int r,int lower,int upper){
        //base case:
        if(l==r){
            return (sum[l]>=lower && sum[l]<=upper)?1:0;
        }
        //divide
        int mid = l+(r-l)/2;
        //conquer+combine
        return process(sum,l,mid,lower,upper)+process(sum,mid+1,r,lower,upper)
                +merge(sum,l,mid,r,lower,upper);
    }
    private int merge(long[] sum,int l,int mid,int r,int lower,int upper){
        //combine
        //must be O(N) time complexity so that overall is O(NlogN);
        int windowL = l;
        int windowR = l;
        int ans = 0;
        int i=0;
        for(i=mid+1;i<=r;++i){
            long min = (long)sum[i]-upper;
            long max = (long)sum[i]-lower;
            while(windowL<=mid && sum[windowL]<min){
                windowL++;
            }
            while(windowR<=mid && sum[windowR]<=max){
                windowR++;
            }
            //[  ,  )
            ans += windowR - windowL;
        }
        long[] helper = new long[r-l+1];
        int p1 = l;
        int p2 = mid+1;
        i=0;
        while(p1<=mid && p2<=r){
            helper[i++] = sum[p1]<=sum[p2]?sum[p1++]:sum[p2++];
        }
        while(p1<=mid){
            helper[i++] = sum[p1++];
        }
        while(p2<=r){
            helper[i++] = sum[p2++];
        }
        for(i=0;i<r-l+1;++i){
            sum[i+l] = helper[i];
        }
        return ans;
    }
}
