package Greedy.LC1187MakeArrayStrictlyIncreasing;

import java.util.Arrays;
import java.util.HashMap;
import javafx.util.Pair;
public class Solution1187 {
    public static HashMap<Pair<Integer,Integer>,Integer> memo = new HashMap<>();
    public static int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Arrays.sort(arr2);
        int ans = dp(0,-1,arr1,arr2);
        return ans<=arr1.length?ans:-1;
    }
    public static int dp(int start,int prev,int[] arr1,int[] arr2){
        if(start==arr1.length)  return 0;
        if(memo.containsKey(new Pair<>(start,prev)))    return memo.get(new Pair<>(start,prev));
        int cost = 9999;
        int id = searchFirstIdGreaterThan(arr2,prev);
        if(arr1[start]>prev){
            cost = Math.min(cost,dp(start+1,arr1[start],arr1,arr2));
            if(id<arr2.length && arr2[id] < arr1[start])  cost = Math.min(cost,1+dp(start+1,arr2[id],arr1,arr2));
        }
        if(id<arr2.length)  cost = Math.min(cost,1+dp(start+1,arr2[id],arr1,arr2));
        memo.put(new Pair<>(start,prev),cost);
        return cost;
    }
    public static int searchFirstIdGreaterThan(int[] arr,int val){
        int left = 0, right = arr.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(arr[mid]<=val)   left = mid+1;
            else    right = mid-1;
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(makeArrayIncreasing(new int[]{1,5,3,6,7},new int[]{4,3,1}));
    }
}
