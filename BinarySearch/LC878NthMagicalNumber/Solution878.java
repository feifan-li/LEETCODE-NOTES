package BinarySearch.LC878NthMagicalNumber;

public class Solution878 {
//    A positive integer is magical if it is divisible by either a or b.
    public static int nthMagicalNumber(int n, int a, int b) {
        //Least Common Multiple: 最小公倍数
        long lcm = (long) a / gcd(a,b) * b;
        long ans = 0;
        long l = 1,r = (long) n*Math.min(a,b),mid = 0;
        while(l<=r){
            mid = l+(r-l)/2;
            if(mid/a+mid/b-mid/lcm >= n){
                ans = mid;
                r = mid-1;
            }else l = mid+1;
        }

        return (int) (ans%1000000007);
    }
    //Greatest Common Divisor: 最大公因数
    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(nthMagicalNumber(1,2,3));
        System.out.println(nthMagicalNumber(4,2,3));
        System.out.println(nthMagicalNumber(5,2,4));
        System.out.println(nthMagicalNumber(3,6,4));
    }
}
