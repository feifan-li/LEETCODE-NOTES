package JavaBasics.LC179LargestNumber;

import java.util.Arrays;
import java.util.Comparator;

public class Solution179 {
    public static class myComparator implements Comparator<String>{
        @Override
        public int compare(String a,String b){
            String ab = a+b;
            String ba = b+a;
            return ba.compareTo(ab);
        }
    }
    public static String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for(int i=0;i<nums.length;++i)  arr[i] = String.valueOf(nums[i]);
        Arrays.sort(arr,new myComparator());
        if(arr[0].charAt(0)=='0') return "0";
        StringBuilder s = new StringBuilder();
        for(int i=0;i<arr.length;++i){
            s.append(arr[i]);
        }
        return s.toString();
    }

    public static void main(String[] args) {
        System.out.println(largestNumber(new int[]{0,0}));
        System.out.println(largestNumber(new int[]{10,2}));
        System.out.println(largestNumber(new int[]{3,30,34,5,9}));

    }
}
