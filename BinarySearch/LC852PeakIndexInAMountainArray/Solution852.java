package BinarySearch.LC852PeakIndexInAMountainArray;

public class Solution852 {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(mid==0){
                left = mid+1;
            }else if(mid==arr.length-1){
                right = mid-1;
            }else if(mid-1>=0 && mid+1<arr.length
                    && arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]){
                return mid;
            }else if(mid-1>=0 && mid+1<arr.length
                    && arr[mid]<arr[mid-1] && arr[mid]>arr[mid+1]){
                right = mid - 1;
            }else if(mid-1>=0 && mid+1<arr.length
                    && arr[mid]>arr[mid-1] && arr[mid]<arr[mid+1]){
                left = mid + 1;
            }
        }
        return -1;
    }
}
