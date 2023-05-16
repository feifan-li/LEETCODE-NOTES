package XOR.LC137SingleNumberII;

public class Solution137 {
    public int singleNumber(int[] nums) {
        int once = 0,twice = 0;
        for(int num:nums){
            once = (~twice)&(once^num);
            twice = (~once)&(twice^num);
        }
        return once;
    }
}
