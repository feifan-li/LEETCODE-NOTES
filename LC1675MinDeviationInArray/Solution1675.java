package LC1675MinDeviationInArray;

import java.util.TreeSet;

public class Solution1675 {
    public static int minimumDeviation(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int num:nums) set.add(num%2==0? num:num*2);
        int res = set.last()-set.first();
        while(set.last()%2==0){//each time only change one number
            int max = set.last();
            set.remove(max);
            set.add(max/2);
            res = Math.min(res,set.last()-set.first());
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(minimumDeviation(new int[]{2,10,8}));//3
        System.out.println(minimumDeviation(new int[]{1,2,3,4}));//1
        System.out.println(minimumDeviation(new int[]{4,1,5,20,3}));//3
        System.out.println(minimumDeviation(new int[]{1,1,1,1,1,2}));//0
        System.out.println(minimumDeviation(new int[]{3,4}));//1
        System.out.println(minimumDeviation(new int[]{4,6}));//1
        System.out.println(minimumDeviation(new int[]{4,7}));//3
        System.out.println(minimumDeviation(new int[]{3,5}));//1
        System.out.println(minimumDeviation(new int[]{102,108}));//3
    }
}
