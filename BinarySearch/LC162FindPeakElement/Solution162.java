package BinarySearch.LC162FindPeakElement;

public class Solution162 {
    public int findPeakElement(int[] nums) {
        //找到一个局部最大值的位置
        if(nums.length==1) return 0;
        int n = nums.length;
        //特殊的局部最大值
        if(nums[0]>nums[1]) return 0;
        if(nums[n-1]>nums[n-2]) return n-1;
        //index 0->1 ascend, index (n-2)->(n-1) desacend, => a peak exist
        int l = 0,r = n-1;
        //从r开始严格递减，至少严格递增至l
        while(l<r-1){//否则数组会越界
            int mid = l + (r-l)/2;
            if(nums[mid-1]<nums[mid] && nums[mid]>nums[mid+1])  return mid;
            else if(nums[mid-1]>nums[mid]){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        //两种情况：l=r 或 l+1=r
        return nums[l]>=nums[r]?l:r;
    }
}
