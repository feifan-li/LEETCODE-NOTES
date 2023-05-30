package CompanyQuestions.HuaweiJishi.HJ82将真分数分解为埃及分数;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> ans = new ArrayList<>();
        String[] fac = in.nextLine().split("/");
        int f1 = Integer.parseInt(fac[0]);
        int f2 = Integer.parseInt(fac[1]);
        int gcd = gcd(f1,f2);
        f1 = f1/gcd;
        f2 = f2/gcd;
        if(f1==1){
            System.out.println("1/"+f2);
            return;
        }
        StringBuilder sb = new StringBuilder();
        int last = f1;
        while(f1>1){
            for(int a=Math.min(last,f1);a>=1;--a){
                if(f2%a==0) {
                    sb.append("1/").append(f2 / a).append("+");
                    f1 = f1 - a;
                    last = a;
                    break;
                }
            }
        }
        if(f1==1) {
            sb.append("1/").append(f2);
            System.out.println(sb);
        }else {
            System.out.println(sb.toString().substring(0,sb.length()-1));
        }
    }
    public static int gcd(int a,int b){
        return b==0?a:gcd(b,a%b);
    }
}
