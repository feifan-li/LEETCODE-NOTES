package CumulativeSum.LC2279MaxBagsWithFullCapacityOfRocks;

import java.util.Arrays;

public class Solution2279 {
    public static int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        int[] remains = new int[n];
        for(int i=0;i<n;++i){
            remains[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(remains);
        int[] sum = new int[n+1];
        for(int i=1;i<=n;++i){
            sum[i] = sum[i-1] + remains[i-1];
        }
        for(int i=0;i<n;++i){
            if(sum[i]<=additionalRocks && sum[i+1]>additionalRocks) return i;
        }
        return sum[n]<=additionalRocks ? n:0;
    }

    public static void main(String[] args) {
        System.out.println(maximumBags(new int[]{2,3,4,5},new int[]{1,2,4,4},2));//3
        System.out.println(maximumBags(new int[]{10,2,2},new int[]{2,2,0},100));//3
    }
}
