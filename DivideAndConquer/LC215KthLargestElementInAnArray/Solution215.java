package DivideAndConquer.LC215KthLargestElementInAnArray;

public class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums,0,nums.length-1,nums.length-k);
    }
    public int quickSort(int[] nums,int L,int R,int k){
        if(L==R)    return nums[L];
        swap(nums,L+(int)(Math.random()*(R-L+1)),R);
        int[] equalRange = partition(nums,L,R);
        if(k>=equalRange[0] && k<=equalRange[1])    return nums[k];
        else if(k<equalRange[0])    return quickSort(nums,L,equalRange[0]-1,k);
        return quickSort(nums,equalRange[1]+1,R,k);
    }
    public int[] partition(int[] nums,int L,int R){
        int lessR = L-1;
        int moreL = R;
        int i = L;
        while(i<moreL){
            if(nums[i]<nums[R]) swap(nums,++lessR,i++);
            else if(nums[i]>nums[R])    swap(nums,--moreL,i);
            else i++;
        }
        swap(nums,moreL,R);
        return new int[]{lessR+1,moreL};
    }
    public void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
