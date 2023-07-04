package XOR.LC137SingleNumberII;

public class Solution137_2 {
    public int singleNumber(int[] nums) {
        int msb = 0, lsb = 0;
        //count = 00,01,10, represented by msb and lsb, counting the freq of bit "1" on each position
        //truth table:
        //--------------------------------------
        //|      INPUT      |      OUTPUT      |
        //| msb | lsb | bit | new_msb | new_lsb|
        //|  0  |  0  |  0  |    0    |    0   |
        //|  0  |  1  |  0  |    0    |    1   |
        //|  1  |  0  |  0  |    1    |    0   |
        //|  1  |  1  |  0  |    X    |    X   |
        //|  0  |  0  |  1  |    0    |    1   |
        //|  0  |  1  |  1  |    1    |    0   |
        //|  1  |  0  |  1  |    0    |    0   |
        //|  1  |  1  |  1  |    X    |    X   |
        //then get the bool expression from K-MAP:
        for(int num:nums){
            int new_msb = (lsb & num)|((~num) & msb) ;
            int new_lsb = (num&~msb&~lsb)|(lsb&~num);
            msb = new_msb;
            lsb = new_lsb;
        }
        //on some positions, bit "1" appear 1+3*n(count=1 => msb=0,lsb=1) times,
        //while on other positions, bit "1" appear 3*n (count=0 => msb=0,lsb=0) times.
        return lsb;//lsb & ~msb
    }
}
