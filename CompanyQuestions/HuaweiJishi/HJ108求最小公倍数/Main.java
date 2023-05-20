package CompanyQuestions.HuaweiJishi.HJ108求最小公倍数;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int A = in.nextInt();
        int B = in.nextInt();
        int gcd = gcd(A,B);
        System.out.println(A*B/gcd);
    }
    public static int gcd(int a,int b){
        return a==0?b:gcd(b%a,a);
    }
}
