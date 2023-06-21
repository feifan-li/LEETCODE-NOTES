package BinarySearch.LC275HIndexII;

public class Solution275 {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int left = 0, right = n-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(n-mid == citations[mid]) return n-mid;
            else if(n-mid > citations[mid]){
                if(mid+1<n && n-mid-1 < citations[mid+1]) return Math.max(Math.min(n-mid,citations[mid]),Math.min(citations[mid+1],n-mid-1));
                left = mid+1;
            }else if(n-mid < citations[mid]){
                if(mid-1>=0 && n-mid+1 > citations[mid-1])  return Math.max(Math.min(citations[mid],n-mid),Math.min(n-mid+1,citations[mid-1]));
                right = mid-1;
            }
        }
        return left==0?n:0;
    }
}
