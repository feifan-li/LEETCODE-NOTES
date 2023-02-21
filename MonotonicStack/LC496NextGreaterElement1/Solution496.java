package MonotonicStack.LC496NextGreaterElement1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution496 {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        Map<Integer,Integer> map = new HashMap<>();
        Stack<Integer> s = new Stack<>();
        for(int i=nums2.length-1;i>=0;--i){
            while(!s.isEmpty() && s.peek()<=nums2[i]){
                s.pop();
            }
            map.put(nums2[i],(s.isEmpty()?-1:s.peek()));
            s.push(nums2[i]);
        }
        for(int i=0;i<nums1.length;++i){
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{4,1,2};
        int[] nums2 = new int[]{1,3,4,2};
        System.out.println(Arrays.toString(nextGreaterElement(nums1,nums2)));
    }
}
