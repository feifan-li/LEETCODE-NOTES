package CompanyQuestions.HuaweiJishi.质数.HJ6_质数因子;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        for(int i=2;i*i<=n;++i){
            while(n%i==0){
                System.out.print(i+" ");
                n /= i;
            }
        }
        System.out.println(n==1?"":n);
    }
}
