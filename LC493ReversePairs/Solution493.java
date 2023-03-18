package LC493ReversePairs;

public class Solution493 {
    public static int reversePairs(int[] nums) {
        if(nums==null || nums.length<2) return 0;
        return process(nums,0,nums.length-1);
    }
    public static int process(int[] nums,int l,int r){
        if(l==r) return 0;
        int mid = l+(r-l)/2;
        return process(nums,l,mid)+process(nums,mid+1,r)+merge(nums,l,mid,r);
    }
    public static int merge(int[] nums,int l,int mid,int r){
        int res = 0;
        int p1 = l;
        int p2 = mid+1;
        for(p1 = l;p1<=mid;++p1){
            while(p2<=r && (long)(nums[p1])>(long)(nums[p2])*2) p2++;
            res += p2-1-mid;
        }

        int[] help = new int[r-l+1];
        p1 = l;
        p2 = mid+1;
        int i = 0;
        while(p1<=mid && p2<=r){
            help[i++] = nums[p1]<=nums[p2]? nums[p1++]:nums[p2++];
        }
        while(p1<=mid) help[i++] = nums[p1++];
        while(p2<=r) help[i++] = nums[p2++];
        for(i=0;i<help.length;++i) nums[i+l] = help[i];
        return res;
    }
}
