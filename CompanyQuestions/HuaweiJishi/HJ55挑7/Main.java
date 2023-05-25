package CompanyQuestions.HuaweiJishi.HJ55挑7;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int ans = 0;
        int n = in.nextInt();
        for(int i=1;i<=n;++i){
            if(i%7==0)  ans++;
            else if((i-(i/10)*10)==7)   ans++;
            else if((i>10 && i/10==7) || lastDigitIsSeven(i/10))    ans++;
            else if((i>100 && i/100==7) || lastDigitIsSeven(i/100))   ans++;
            else if((i>1000 && i/1000==7) || lastDigitIsSeven(i/1000))    ans++;
        }
        System.out.println(ans);
    }
    private static boolean lastDigitIsSeven(int a){ return (a-(a/10)*10)==7;}
}
