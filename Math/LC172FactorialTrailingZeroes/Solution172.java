package Math.LC172FactorialTrailingZeroes;

public class Solution172 {
    public int trailingZeroes(int n) {
        //O(logn) time complexity
        if(n<5) return 0;
        return n/5+trailingZeroes(n/5);
    }
}
