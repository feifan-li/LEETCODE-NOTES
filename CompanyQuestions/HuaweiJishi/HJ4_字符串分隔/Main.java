package CompanyQuestions.HuaweiJishi.HJ4_字符串分隔;

import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String s = in.nextLine();
            int n = s.length();
            if(n==0) continue;
            int i=0;
            while(i+8<n){
                System.out.println(s.substring(i,i+8));
                i = i+8;
            }
            if(i<n){
                char[] buf = new char[8];
                Arrays.fill(buf,'0');
                int j = i;
                while(i<n){
                    buf[i-j] = s.charAt(i);
                    i++;
                }
                System.out.println(String.valueOf(buf));
            }
        }
    }
}
