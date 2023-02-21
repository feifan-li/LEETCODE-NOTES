package BinarySearch.LC1539KthMissingPositiveNumber;
//Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
//Return the kth positive integer that is missing from this array.
import java.util.HashSet;

public class Solution1539 {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i:arr){set.add(i);}
        int cnt = 0;
        for(int i=1;i<=arr[n-1];++i){
            if(!set.contains(i)) {
                cnt++;
                if(cnt==k) return i;
            }
        }
        return arr[n-1]+k-cnt;
    }
}
