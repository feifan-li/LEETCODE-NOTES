package CompanyQuestions.HuaweiJishi.判断闰年.HJ73计算日期到天数转换;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int year = in.nextInt();
        int month = in.nextInt();
        int date = in.nextInt();
        int[] months1 = new int[]{0,31,28,31,30,31,30,31,31,30,31,30,31};
        int[] sum1 = new int[13];
        for(int i=1;i<=12;++i){
            sum1[i] = sum1[i-1]+months1[i];
        }
        int[] months2 = new int[]{0,31,29,31,30,31,30,31,31,30,31,30,31};
        int[] sum2 = new int[13];
        for(int i=1;i<=12;++i){
            sum2[i] = sum2[i-1]+months2[i];
        }
        if((year%4==0 && year%100!=0) || (year%400==0)){//leap year
            System.out.println(sum2[month-1]+date);
        }else{
            System.out.println(sum1[month-1]+date);
        }
    }
}
