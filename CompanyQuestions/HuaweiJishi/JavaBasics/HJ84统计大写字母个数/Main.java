package CompanyQuestions.HuaweiJishi.JavaBasics.HJ84统计大写字母个数;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int cnt = 0;
        for(int i=0;i<s.length();++i){
            if(s.charAt(i)-'A'>=0 && s.charAt(i)-'Z'<=0)    cnt++;
        }
        System.out.println(cnt);
    }
}
