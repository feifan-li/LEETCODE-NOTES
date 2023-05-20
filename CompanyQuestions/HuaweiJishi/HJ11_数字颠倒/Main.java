package CompanyQuestions.HuaweiJishi.HJ11_数字颠倒;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] s = in.nextLine().toCharArray();
        for(int i=0;i<s.length/2;++i){
            char tmp = s[i];
            s[i] = s[s.length-1-i];
            s[s.length-1-i] = tmp;
        }
        System.out.println(String.valueOf(s));
    }
}
