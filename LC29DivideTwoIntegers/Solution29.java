package LC29DivideTwoIntegers;

public class Solution29 {
    public static int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor==-1) return  Integer.MAX_VALUE;
        if(dividend==0) return 0;
        else{
            int sign = 1;
            long ldividend = (long)dividend;
            long ldivisor = (long)divisor;
            if((ldividend>0 && ldivisor<0)||(ldividend<0 && ldivisor>0)) sign=-1;
            ldividend = Math.abs(ldividend);
            ldivisor = Math.abs(ldivisor);
            long res;

            if(ldividend<ldivisor) return 0;
            else{
                res = ldividend/ldivisor;
            }
            return (int)(sign*res);
        }
    }
    public static void main(String[] args) {
        System.out.println(divide(10,3));
        System.out.println(divide(7,-3));
        System.out.println(divide(-2147483648,-1));
        System.out.println(divide(-2147483648,1));
        System.out.println(divide(-2147483648,2));
        System.out.println(divide(-2147483648,-2147483648));
    }
}
