package CompanyQuestions.HuaweiJishi.HJ57高精度整数加法;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        int[] num1 = new int[Math.max(s1.length(),s2.length())];
        int[] num2 = new int[Math.max(s1.length(),s2.length())];
        int carry = 0;
        int i1 = num1.length-1, i2 = num2.length-1;
        for(int i=s1.length()-1;i>=0;--i){
            num1[i1] = s1.charAt(i)-'0';
            i1--;
        }
        for(int i=s2.length()-1;i>=0;--i){
            num2[i2] = s2.charAt(i)-'0';
            i2--;
        }
        for(int i=num1.length-1;i>=0;--i){
            num2[i] +=(carry+num1[i]);
            if(num2[i]>=10){
                num2[i] -= 10;
                carry = 1;
            }else{
                carry = 0;
            }
        }
        if(carry==1)    System.out.print(carry);
        for(int i=0;i<num2.length;++i){
            System.out.print(num2[i]);
        }
        System.out.println();
    }
}
