package CompanyQuestions.HuaweiJishi.JavaBasics.HJ81字符串字符匹配;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        int[] map = new int[26];
        for(int i=0;i<s2.length();++i){
            map[s2.charAt(i)-'a'] = 1;
        }
        for(int i=0;i<s1.length();++i){
            if(map[s1.charAt(i)-'a']!=1){
                System.out.println(false);
                return;
            }
        }
        System.out.println(true);
    }
}
