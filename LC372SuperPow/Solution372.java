package LC372SuperPow;
//Your task is to calculate a^b mod 1337 where a is a positive integer and b is an extremely large positive integer given in the form of an array.
// (a*b)%k = (a%k)*(b%k)%k
public class Solution372 {
    final static int BASE = 1337;
    public static int myPow(int a, int k){
        if(k==0) return 1;
        a %= BASE;
        if(k%2==1){
            return a*(myPow(a,k-1))%BASE;
        }else{
            int sub = myPow(a,k/2);
            return (sub*sub)%BASE;
        }
    }
    public static int superPow(int a, int[] b) {
        int len = b.length;
        return superPow(a,b,len);
    }
    public static int superPow(int a, int[] b, int length){
        if(length==0) return 1;
        int last = b[length-1];
        --length;
        int part1 = myPow(a,last);
        int part2 = myPow(superPow(a,b,length),10);
        return (part1*part2)%BASE;
    }

    public static void main(String[] args) {
        int a1=2;
        int[] b1 = new int[]{4,3,3,8,5,3};

        int a2=3;
        int[] b2 = new int[]{2,0};

        System.out.println(superPow(a1,b1));
        System.out.println(superPow(a2,b2));

    }
}
