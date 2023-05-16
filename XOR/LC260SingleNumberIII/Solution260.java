package XOR.LC260SingleNumberIII;

public class Solution260 {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int num:nums){
            xor ^= num;
        }
        int RightOne = xor&(-xor);
        int a = 0;
        for(int num:nums){
            if((num&RightOne)!=0)   a ^= num;
        }
        return new int[]{a,(xor^a)};
    }
}
