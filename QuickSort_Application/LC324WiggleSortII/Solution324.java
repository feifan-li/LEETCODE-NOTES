package QuickSort_Application.LC324WiggleSortII;

import java.util.LinkedList;

public class Solution324 {
    public void wiggleSort(int[] nums) {
        int n = nums.length, median = quickSort(nums,0,n-1,n%2==0?n/2:(n+1)/2);
        System.out.println(median);
        LinkedList<Integer> big = new LinkedList<>();
        LinkedList<Integer> small = new LinkedList<>();
        for(int num:nums){
            if(num > median) big.add(num);
            else if(num < median)    small.add(num);
        }
        while(big.size()<n/2)   big.addFirst(median);
        while(small.size()+big.size()<n)    small.add(median);
        int even = 0, odd = 0;
        for(int i=0;i<nums.length;++i){
            if(i%2==0)  nums[i] = small.pollLast();
            else nums[i] = big.pollLast();
        }
    }
    public int quickSort(int[] nums,int L,int R,int k){
        if(L>=R)    return nums[L];
        swap(nums,L+(int)(Math.random()*(R-L+1)),R);
        int[] equal = partition(nums,L,R);
        if(equal[0]<=k && k<=equal[1])  return nums[k];
        else if(equal[0]>k) return quickSort(nums,L,equal[0]-1,k);
        return quickSort(nums,equal[1]+1,R,k);
    }
    public int[] partition(int[] nums,int L,int R){
        int lessR = L-1, moreL = R, i = L;
        while(i<moreL){
            if(nums[i]<nums[R])         swap(nums,++lessR,i++);
            else if(nums[i]>nums[R])    swap(nums,--moreL,i);
            else    i++;
        }
        swap(nums,moreL++,R);
        return new int[]{lessR+1,moreL-1};
    }
    public void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
