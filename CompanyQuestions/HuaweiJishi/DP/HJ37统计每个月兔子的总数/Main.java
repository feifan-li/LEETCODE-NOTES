package CompanyQuestions.HuaweiJishi.DP.HJ37统计每个月兔子的总数;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int newborn = 1,age1 = 0,fertile = 0;
        for(int i=2;i<=n;++i){
            fertile += age1;
            age1 = newborn;
            newborn = fertile;
        }
        System.out.println(newborn + age1 + fertile);
    }
}
