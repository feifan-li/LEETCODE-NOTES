package CompanyQuestions.HuaweiJishi.质数.HJ60查找组成一个偶数最接近的两个素数;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        boolean[] notPrime = new boolean[n+1];
        for(int i=2;i*i<=n;++i){
            if(!notPrime[i]){
                for(int j=i*i;j<=n;j=j+i){
                    notPrime[j] = true;
                }
            }
        }
        int diff = Integer.MAX_VALUE;
        int[] ans = new int[2];
        for(int i=n/2;i>=2;--i){
            if(!notPrime[i]){
                if(!notPrime[n-i]){
                    System.out.println(i);
                    System.out.println(n-i);
                    break;
                }
            }
        }
    }
}
