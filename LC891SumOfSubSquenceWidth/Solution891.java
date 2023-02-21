package LC891SumOfSubSquenceWidth;

import java.util.Arrays;

public class Solution891 {
    public static int sumSubseqWidths(int[] nums) {
        //所有子序列的宽度的和
        Arrays.sort(nums);
        final int MOD = 1000000007;
        long ans = 0;
        //排序后：a, b, c, d, e
        //ans =
        //1) b - a = b*2^0 - a*2^0
        //2) (c - b) + (c - a）* 2^1 = c*(2^0 + 2^1) - a*2^1 - b*2^0
        //3) (d - c) + (d - b) * 2^1 + (d - a) * 2^2 = d*(2^0 + 2^1 + 2^2) - a*2^2 - b*2^1 - c*2^0
        //4) (e - d) + (e - c) * 2^1 + (e - b) * 2^2 + (e - a) * 2^3 =
        //   e*(2^0 + 2^1 + 2^2 + 2^3) - a*2^3 - b*2^2 - c*2^1 - d*2^0
        long A = 0, B = 0, C = 1, D = 1;// C=2^0, D=2^0
        for(int i=1;i<nums.length;++i){
            A = (nums[i]*D)%MOD;
            B = (B*2%MOD + nums[i-1])%MOD;
            ans = (ans+ A - B + MOD)%MOD;
            C = (C*2)%MOD;
            D = (D+C)%MOD;
        }
        return (int) (ans);
    }

    public static void main(String[] args) {
        System.out.println(sumSubseqWidths(new int[]{93,30,5,13,19,98,46,16,9,10,29,57,6,70,55,95,94,47,3,30,42,29,74,10,11,15,81,52,24,58,76,59,19,66,26,87,47,33,96,2,67,52,53,86,12,36,2,41,35,53}));
    }
}
