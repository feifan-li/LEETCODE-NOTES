package CompanyQuestions.HuaweiJishi.JavaBasics.HJ46截取字符串;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int k = in.nextInt();
        System.out.println(s.substring(0,k));
    }
}
