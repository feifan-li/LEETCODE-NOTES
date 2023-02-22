package BitManipulation.LC29DivideTwoIntegers;

public class Solution29 {
    public static int div(int a, int b){
        int x = a<0?-a:a;
        int y = b<0?-b:b;
        int res = 0;
        //x / y
        for(int i=30;i>=0;i--){
            if((x>>i)>=y){
                res |= (1<<i);
                x -= (y<<i);
            }
        }
        return (a<0)^(b<0) ? (-res):res;
    }
    public static int divide(int dividend, int divisor) {
        //系统最小值的绝对值还是系统最小值
        //Integer.MIN_VALUE = 1000 0000 0000 0000 0000 0000 0000 0000
        if(dividend==Integer.MIN_VALUE && divisor==Integer.MIN_VALUE){
            return 1;
        }else if(divisor==Integer.MIN_VALUE){
            return 0;
        }else if(dividend==Integer.MIN_VALUE){
            if(divisor==1){
                return Integer.MIN_VALUE;
            }else if(divisor==-1){
                return Integer.MAX_VALUE;
            }else{
                int c = div(dividend+1,divisor);
                return c+div(dividend-c*divisor,divisor);
            }
        }else{
            return div(dividend,divisor);
        }
    }
}
