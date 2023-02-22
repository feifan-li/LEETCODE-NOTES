package BitManipulation.LC421MaxXORofTwoNumbersInAnArray;

import java.util.HashSet;

public class Solution421 {
    public int findMaximumXOR(int[] nums) {
        int res = 0;
        int mask = 0;
        for(int i=30;i>=0;--i){
            mask |= (1<<i);
            HashSet<Integer> prefixSet = new HashSet<>();
            for(int n:nums) prefixSet.add(n & mask);
            int tmp = res^(1<<i);
            for(int n:prefixSet){
                if(prefixSet.contains(tmp^n)){
                    res = tmp;
                    break;
                }
            }
        }
        return res;
    }
}
