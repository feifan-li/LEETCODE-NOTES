package LC88Merge2SortedArray;
//nums1.length == m + n
//nums2.length == n
//You are given two integer arrays nums1 and nums2, sorted in non-decreasing order
//and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
//The final sorted array should not be returned by the function, but instead be stored inside the array nums1
public class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1, p2 = n-1;
        for(int k=m+n-1;k>=0;--k){
            if(p1==-1){
                System.arraycopy(nums2,0,nums1,0,p2+1);
                break;
            }
            if(p2==-1){
                break;
            }
            if(nums1[p1]>nums2[p2]){
                nums1[k] = nums1[p1];
                --p1;
            }else{
                nums1[k] = nums2[p2];
                --p2;
            }
        }
    }
}
