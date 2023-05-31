package CompanyQuestions.HuaweiJishi.JavaBasics.计负均正.HJ97计负均正;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int negCnt = 0;
        double posCnt = 0.0, posSum = 0.0;
        for(int i=0;i<n;++i){
            int num = in.nextInt();
            if(num<0)   negCnt++;
            else if(num>0){
                posCnt += 1.0;
                posSum += num*1.0;
            }
        }
        System.out.println(negCnt+" "+(posCnt==0?0.0:String.format("%.1f",posSum/posCnt)));
    }
}
