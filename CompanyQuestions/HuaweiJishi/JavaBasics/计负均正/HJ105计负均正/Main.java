package CompanyQuestions.HuaweiJishi.JavaBasics.计负均正.HJ105计负均正;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int negCnt = 0,nonNegCnt = 0;
        double nonNegSum = 0.0;
        while(in.hasNextInt()){
            int num = in.nextInt();
            if(num<0)   negCnt++;
            else{
                nonNegCnt++;
                nonNegSum += num;
            }
        }
        System.out.println(negCnt);
        System.out.println((nonNegCnt==0?0.0:String.format("%.1f",nonNegSum/(nonNegCnt*1.0))));
    }
}
