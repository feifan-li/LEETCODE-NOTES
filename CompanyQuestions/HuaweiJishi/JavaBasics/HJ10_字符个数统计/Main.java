package CompanyQuestions.HuaweiJishi.JavaBasics.HJ10_字符个数统计;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        char[] sarr = s.toCharArray();
        HashSet<Character> set = new HashSet<>();
        int ans = 0;
        for(char c:sarr){
            if(!set.contains(c)){
                set.add(c);
                ans++;
            }
        }
        System.out.println(ans);
    }
}
