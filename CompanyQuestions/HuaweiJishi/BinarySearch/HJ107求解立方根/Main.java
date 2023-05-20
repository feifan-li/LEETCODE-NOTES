package CompanyQuestions.HuaweiJishi.BinarySearch.HJ107求解立方根;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        double val = in.nextDouble();
        double eclipse = 0.00001;
        if(val==0.0){
            System.out.println("0.0");
        }
        int flag = val>0?1:-1;
        val = val*flag;
        double left = val>=1.0?1.0:val;
        double right = val>=1.0?val:1.0;
        double ans = (left+right)/2;
        while(Math.abs(ans*ans*ans-val)>eclipse){
            if(ans*ans*ans > val){
                right = ans;
            }else{
                left = ans;
            }
            ans = (left+right)/2;
        }
        ans = ans*flag;
        String  str = String.format("%.1f",ans);
        System.out.println(str);
    }
}
