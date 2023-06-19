package DynamicProgramming.LC264UglyNumberII;

public class Solution264 {
    public int nthUglyNumber(int n) {
        int[] nums = new int[n];
        nums[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0; //used to track the index of numbers array that are multiplied by 2,3,5
        for(int i=1;i<n;++i){
            nums[i] = Math.min(nums[index2]*2,Math.min(nums[index3]*3,nums[index5]*5));
            if(nums[i]==nums[index2]*2) index2++;
            if(nums[i]==nums[index3]*3) index3++;
            if(nums[i]==nums[index5]*5) index5++;
        }
        return nums[n-1];
    }
}
