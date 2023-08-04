package BinarySearch.LC702SearchInSortedArrayOfUnknownSize;

public class Solution702 {
    public int search(ArrayReader reader, int target) {
        int left = 0, right = target-reader.get(0);//at most target-get(0)+1 elements
        while(left<=right){
            int mid = left + (right-left)/2;
            if(reader.get(mid)==target) return mid;
            else if(reader.get(mid)>target) right = mid-1;
            else left = mid+1;
        }
        return -1;
    }
}
