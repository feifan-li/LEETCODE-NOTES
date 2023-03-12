package LC1201UglyNumberIII;

public class Solution1201 {
    public static int nthUglyNumber(int target, int a, int b, int c) {
        //binary search
        long left = (long)(Math.min(a,Math.min(b,c)));
        long right = (long)Integer.MAX_VALUE;
        while(left<=right){
            long mid = left+(right-left)/2;
            long cur = getCntOfUglyNums(mid,a,b,c);
            if(cur>=(long)target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return (int)left;
    }
    public static long gcd(long a,long b){
        return b==0?a:gcd(b,a%b);
    }
    public static long lcm(long a,long b){
        return a*b/gcd(a,b);
    }
    public static long lcm(long a,long b,long c){
        long x = lcm(a,b);
        return x*c/gcd(x,c);
    }
    public static long getCntOfUglyNums(long k,int a,int b,int c){
        return k/(long)a+k/(long) b+k/(long)c
                -k/lcm((long)a,(long)b)
                -k/lcm((long)a,(long)c)
                -k/lcm((long)b,(long)c)
                +k/lcm((long)a,(long)b,(long)c);
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(1000000000,2,217983653,336916467));//1999999984
        System.out.println(nthUglyNumber(5,2,4,8));//10
        System.out.println(nthUglyNumber(4,2,3,4));//6
        System.out.println(nthUglyNumber(7,7,7,7));//49
    }
}
