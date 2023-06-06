package LC1502CanMakeArithmeticProgressionFromSequence;

import java.util.Arrays;

public class Solution1502 {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int d = arr[1] - arr[0];
        for(int i=2;i<arr.length;++i){
            if(d!=arr[i] - arr[i-1])    return false;
        }
        return true;
    }
}
