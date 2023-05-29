package CompanyQuestions.HuaweiJishi.HJ76尼科彻斯定理;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        //m^3 = a1+a2+...+am = m*a1+2+4+6+...+2*(m-1) = m*a1 + 2*(1+2+3+...+m-1) = m*(a1+m-1)
        //since m>=1, m^3 = m*(a1+m-1)  =>  m^2 = a1+m-1  =>  a1 = m^2-m+1
        int a1 = m*m - m +1;
        for(int i=0;i<m-1;++i){
            System.out.print((a1+2*i)+"+");
        }
        System.out.println(a1+2*(m-1));
    }
}
