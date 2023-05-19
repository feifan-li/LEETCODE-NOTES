package PrimeNumber.LC204CountPrimes;
import java.util.Arrays;

//Given an integer n, return the number of prime numbers that are strictly less than n.
public class Solution204 {
    public static int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime,true);
        for(int i=2;i*i<=n;++i){
            if(isPrime[i]){
                for(int j = i*i;j<n;j=j+i){
                    isPrime[j] = false;
                }
            }
        }
        int cnt = 0;
        for(int i=2;i<n;++i){
            if(isPrime[i]) ++cnt;
        }

        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(0));
        System.out.println(countPrimes(1));
        System.out.println(countPrimes(10));
        System.out.println(countPrimes(100));
    }
}
